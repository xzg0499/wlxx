package com.xzg.wlxx.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.DictDto;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.service.DictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "字典")
@RequestMapping("dict")
@RequiredArgsConstructor
public class DictController {

    private final DictService service;

    @PostMapping("add")
    @Operation(summary = "新增字典")
    public ApiResult<Boolean> add(@RequestBody DictDto dto) {
        return ApiResult.success(service.add(dto));
    }

    @GetMapping("findByCode/{code}")
    @Operation(summary = "根据code查找字典")
    public ApiResult<List<DictPo>> findByCode(@PathVariable String code) {
        return ApiResult.success(service.findByCode(code));
    }

    @GetMapping("search")
    public ApiResult<IPage<DictPo>> search(DictDto dto) {
        return ApiResult.success();
    }
}
