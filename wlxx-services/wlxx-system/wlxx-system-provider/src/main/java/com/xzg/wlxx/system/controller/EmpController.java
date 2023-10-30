package com.xzg.wlxx.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.EmpDto;
import com.xzg.wlxx.system.client.entity.po.EmpPo;
import com.xzg.wlxx.system.service.EmpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "员工")
@RequestMapping("emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService service;

    @PostMapping("save")
    @Operation(summary = "新增员工")
    public ApiResult<Boolean> save(@RequestBody @Validated EmpDto dto) {
        return ApiResult.success(service.add(dto));
    }

    @GetMapping("searchByOrg")
    @Operation(summary = "根据组织查询员工")
    public ApiResult<IPage<EmpPo>> searchByOrg(EmpDto dto) {
        return ApiResult.success(service.searchByOrg(dto));
    }
}
