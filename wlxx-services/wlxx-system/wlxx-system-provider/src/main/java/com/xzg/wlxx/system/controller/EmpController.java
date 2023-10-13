package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.EmpDto;
import com.xzg.wlxx.system.service.EmpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "emp")
@RequestMapping("emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService service;

    @PostMapping("save")
    public ApiResult<Boolean> save(@RequestBody @Validated EmpDto dto) {
        return ApiResult.success(service.add(dto));
    }
}
