package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.DictDto;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.service.DictService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "dict")
@RequestMapping("dict")
@RequiredArgsConstructor
public class DictController {

    private final DictService service;

    @PostMapping("save")
    public ApiResult<Boolean> save(@RequestBody DictDto dto) {
        return ApiResult.success(service.add(dto));
    }

    @GetMapping("findByCode/{code}")
    public ApiResult<List<DictPo>> findByCode(@PathVariable String code) {
        return ApiResult.success(service.findByCode(code));
    }
}
