package com.xzg.wlxx.module.service.impl;

import com.xzg.wlxx.module.entity.TDict;
import com.xzg.wlxx.module.mapper.TDictMapper;
import com.xzg.wlxx.module.service.ITDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-01-13
 */
@Service
public class TDictServiceImpl extends ServiceImpl<TDictMapper, TDict> implements ITDictService {
    @Autowired
    private TDictMapper tDictMapper;

    @Override
    public int add(TDict entity) {
        return tDictMapper.insert(entity);
    }

    @Override
    public List<TDict> queryAll() {
        return tDictMapper.selectAll();
    }
}
