package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.dto.DictDto;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.mapper.DictMapper;
import com.xzg.wlxx.system.service.DictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoZG
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, DictPo> implements DictService {


    @Override
    public boolean add(DictDto dto) {
        var exists = lambdaQuery()
                .eq(StrUtil.isNotBlank(dto.getDictCode()), DictPo::getDictCode, dto.getDictCode())
                .exists();
        Assert.isTrue(exists, "编码已存在");
        return save(dto);
    }

    @Override
    public List<DictPo> findByCode(String code) {
        Assert.notBlank(code, "code 不能为空");
        return lambdaQuery()
                .eq(StrUtil.isNotBlank(code), DictPo::getDictCode, code)
                .list();
    }
}
