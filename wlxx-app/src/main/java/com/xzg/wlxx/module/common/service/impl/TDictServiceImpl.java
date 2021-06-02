package com.xzg.wlxx.module.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.module.common.entity.TDict;
import com.xzg.wlxx.module.common.mapper.TDictMapper;
import com.xzg.wlxx.module.common.service.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzgang
 * @since 2021-05-05
 */
@Service
public class TDictServiceImpl extends ServiceImpl<TDictMapper, TDict> implements ITDictService {
    @Autowired
    TDictMapper tDictMapper;

    @Override
    public List<TDict> select() {
        return tDictMapper.select();
    }
}
