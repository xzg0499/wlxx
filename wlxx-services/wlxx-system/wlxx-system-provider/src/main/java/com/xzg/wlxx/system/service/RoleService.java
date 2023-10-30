package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.RoleDto;
import com.xzg.wlxx.system.client.entity.po.RolePo;

/**
 * @author XiaoZG
 */
public interface RoleService extends IService<RolePo> {

    boolean save(RoleDto dto);
}
