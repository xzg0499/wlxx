package com.xzg.wlxx.module.service;

import com.xzg.wlxx.module.entity.TDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-01-13
 */
public interface ITDictService extends IService<TDict> {
    public int add(TDict entity);
    public List<TDict> queryAll();
}
