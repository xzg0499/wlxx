package com.xzg.wlxx.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.framework.entity.TDict;
import com.xzg.wlxx.framework.mapper.TDictMapper;
import com.xzg.wlxx.framework.service.ITDictService;
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
