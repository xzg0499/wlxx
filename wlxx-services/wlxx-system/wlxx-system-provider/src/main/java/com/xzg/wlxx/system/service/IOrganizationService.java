package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.OrganizationPo;
import com.xzg.wlxx.system.client.entity.vo.OrganizationVo;

import java.util.List;

/**
 * <p>
 * 组织 服务类
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
public interface IOrganizationService extends IService<OrganizationPo> {

    /**
     * 新增组织
     */
    boolean add(OrganizationPo po);

    /**
     * 更新组织
     */
    boolean edit(OrganizationPo po);

    /**
     * 获取组织结构
     */
    List<OrganizationVo> get(Long id);
}
