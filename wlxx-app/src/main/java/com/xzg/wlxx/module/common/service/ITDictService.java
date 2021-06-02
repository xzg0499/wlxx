package com.xzg.wlxx.module.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.module.common.entity.TDict;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzgang
 * @since 2021-05-05
 */
public interface ITDictService extends IService<TDict> {
    public List<TDict> select();
}
