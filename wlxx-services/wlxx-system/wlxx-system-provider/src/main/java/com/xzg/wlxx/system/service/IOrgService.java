package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;

import java.util.List;

/**
 * <p>
 * 组织 服务类
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
public interface IOrgService extends IService<Org> {

    /**
     * 新增组织
     */
    boolean add(Org po);

    /**
     * 更新组织
     */
    boolean edit(Org po);

    /**
     * 获取组织结构
     */
    List<OrgVo> get(Long id);
}
