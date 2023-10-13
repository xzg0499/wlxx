package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.TenantPo;
import com.xzg.wlxx.system.mapper.TenantMapper;
import com.xzg.wlxx.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TenantServiceImpl extends ServiceImpl<TenantMapper, TenantPo> implements TenantService {
}
