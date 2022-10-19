package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.core.base.BaseIService;
import com.xzg.wlxx.system.client.entity.TDict;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
public interface ITDictService extends BaseIService<TDict> {

    Boolean add(TDict dict) throws Exception;

    Boolean modify(TDict dict) throws Exception;

    IPage<TDict> query(TDict dict) throws Exception;

    TDict getByCode(String code) throws Exception;

    Boolean delById(String id) throws Exception;

}
