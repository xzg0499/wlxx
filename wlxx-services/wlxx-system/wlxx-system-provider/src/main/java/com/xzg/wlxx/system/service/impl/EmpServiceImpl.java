package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.dto.EmpDto;
import com.xzg.wlxx.system.client.entity.po.EmpPo;
import com.xzg.wlxx.system.mapper.EmpMapper;
import com.xzg.wlxx.system.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmpServiceImpl extends ServiceImpl<EmpMapper, EmpPo> implements EmpService {

    @Override
    public IPage<EmpPo> searchByOrg(EmpDto dto) {
        Assert.notNull(dto.getOrgId(), "orgId不能为空");
        return page(new Page<>(dto.getPage(), dto.getSize())
                , Wrappers.<EmpPo>lambdaQuery()
                        .eq(EmpPo::getOrgId, dto.getOrgId())
        );
    }

    @Override
    public boolean add(EmpDto dto) {
        var exists = lambdaQuery()
                .eq(StrUtil.isNotBlank(dto.getEmpCode()), EmpPo::getEmpCode, dto.getEmpCode())
                .exists();
        if (exists) {
            throw new BusinessException("empCode 已存在");
        }
        return save(dto.toPo(EmpPo.class));
    }
}
