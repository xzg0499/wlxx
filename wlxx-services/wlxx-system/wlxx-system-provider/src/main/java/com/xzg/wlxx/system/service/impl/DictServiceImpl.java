package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.po.Dict;
import com.xzg.wlxx.system.mapper.DictMapper;
import com.xzg.wlxx.system.service.IDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Service
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {


    @Override
    public boolean add(Dict po) {
        boolean exists = baseMapper.exists(Wrappers.<Dict>lambdaQuery()
                .eq(Dict::getDictCode, po.getDictCode())
        );
        if (exists) {
            throw new BusinessException("字典编码【{}】已存在", po.getDictCode());
        }
        return save(po);
    }

    @Override
    public boolean edit(Dict po) {
        return updateById(po);
    }

    @Override
    public IPage<Dict> search(DictParam param) {
        return page(param.getPage());
    }

    @Override
    public boolean enabled(Long id, boolean enabled) {
        return lambdaUpdate().set(Dict::getEnabled, enabled)
                .eq(Dict::getId, id).update();
    }
}
