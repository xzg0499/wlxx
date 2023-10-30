package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.RoleDto;
import com.xzg.wlxx.system.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "role")
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping("add")
    @Operation(summary = "添加角色")
    public ApiResult<Boolean> add(@RequestBody RoleDto dto) {
        return ApiResult.success(service.save(dto));
    }
}
