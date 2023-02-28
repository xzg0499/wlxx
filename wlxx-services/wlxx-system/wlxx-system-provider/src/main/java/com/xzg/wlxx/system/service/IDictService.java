package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.po.DictPo;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
public interface IDictService extends IService<DictPo> {

    /**
     * 添加
     */
    boolean add(DictPo po);

    /**
     * 编辑
     */
    boolean edit(DictPo po);

    /**
     * 分页查询
     * @param param
     * @return
     */
    IPage<DictPo> search(DictParam param);

    /**
     * 启用/禁用
     */
    boolean enabled(Long id, boolean enabled);
}
