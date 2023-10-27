package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.dto.TenantDto;
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

    @Override
    public IPage<TenantPo> search(TenantDto dto) {
        return page(new Page<>(dto.getPage(), dto.getSize())
                , Wrappers.<TenantPo>lambdaQuery()
                        .orderByDesc(TenantPo::getCreateDate)
        );
    }
}
