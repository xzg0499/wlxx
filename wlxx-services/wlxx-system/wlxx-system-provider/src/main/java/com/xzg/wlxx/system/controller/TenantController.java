package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.dto.TenantDto;
import com.xzg.wlxx.system.service.TenantService;
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
@Tag(name = "tenant")
@RequestMapping("tenant")
@RequiredArgsConstructor
public class TenantController extends BaseController {

    private final TenantService service;

    @PostMapping("add")
    public ApiResult<Boolean> add(@RequestBody TenantDto dto) {
        return ApiResult.success(service.save(dto));
    }
}
