package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.dto.RoleDto;
import com.xzg.wlxx.system.client.entity.po.RolePo;
import com.xzg.wlxx.system.mapper.RoleMapper;
import com.xzg.wlxx.system.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RolePo> implements RoleService {

    @Override
    public boolean save(RoleDto dto) {
        Assert.notBlank(dto.getRoleCode(), "roleCode 不能为空");
        return save(dto);
    }
}
