package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.common.core.base.BaseIService;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.client.entity.TDictItem;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
public interface ITDictItemService extends IService<TDictItem> {
    Boolean add(TDictItem dictItem)throws Exception;

    Boolean modify(TDictItem dictItem) throws Exception;

    IPage<TDictItem> query(TDictItem dictItem) throws Exception;

    TDictItem getByCode(String code) throws Exception;
}
