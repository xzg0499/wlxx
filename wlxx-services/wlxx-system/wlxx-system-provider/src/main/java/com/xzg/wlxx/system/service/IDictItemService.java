package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.DictItem;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
public interface IDictItemService extends IService<DictItem> {

    /**
     * 新增字典项
     */
    boolean add(DictItem po);

}
