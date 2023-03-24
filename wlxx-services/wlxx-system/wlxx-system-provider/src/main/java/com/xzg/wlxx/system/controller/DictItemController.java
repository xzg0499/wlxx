package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.system.client.entity.param.EnabledParam;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import com.xzg.wlxx.system.service.IDictItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典项管理
 *
 * @author xzgan
 * @date 2023/3/24
 */
@RestController
@RequestMapping("/dict-item")
@Tag(name = "数据字典管理-字典项管理", description = "数据字典管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictItemController {

    private final IDictItemService service;

    @Operation(summary = "新增字典项")
    @PostMapping("add")
    public RestApiResult add(@RequestBody DictItem po) {
        return ApiResult.msg(service.add(po));
    }

    @Operation(summary = "启用/禁用")
    @PutMapping("enabled")
    public RestApiResult enabled(@RequestBody EnabledParam param) {
        return ApiResult.msg(service.enabled(param.getId(), param.getEnabled()));
    }
}
