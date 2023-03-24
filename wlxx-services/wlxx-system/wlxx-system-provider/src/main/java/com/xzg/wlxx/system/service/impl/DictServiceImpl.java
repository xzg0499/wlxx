package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.po.DictPo;
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
public class DictServiceImpl extends ServiceImpl<DictMapper, DictPo> implements IDictService {


    @Override
    public boolean add(DictPo po) {
        return save(po);
    }

    @Override
    public boolean edit(DictPo po) {
        return updateById(po);
    }

    @Override
    public IPage<DictPo> search(DictParam param) {
        return page(param.getPage());
    }

    @Override
    public boolean enabled(Long id, boolean enabled) {
        return lambdaUpdate().set(DictPo::getEnabled, enabled)
                .eq(DictPo::getId, id).update();
    }
}
