package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.TenantDto;
import com.xzg.wlxx.system.client.entity.po.TenantPo;

/**
 * @author XiaoZG
 */
public interface TenantService extends IService<TenantPo> {

    IPage<TenantPo> search(TenantDto dto);
}
