package com.xzg.wlxx.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.dto.TenantDto;
import com.xzg.wlxx.system.client.entity.po.TenantPo;
import com.xzg.wlxx.system.service.TenantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ApiResult<IPage<TenantPo>> search(TenantDto dto) {
        return ApiResult.success();
    }
}
