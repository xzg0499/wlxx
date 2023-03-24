package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import com.xzg.wlxx.system.service.IDictItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzgan
 * @date 2023/3/24
 */
@RestController
@RequestMapping("/dict-item")
@Tag(name = "字典项管理", description = "数据字典管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictItemController {

    private final IDictItemService service;

    @Operation(summary = "新增字典项", description = "新增字典项")
    @PostMapping("add")
    public RestApiResult add(@RequestBody DictItem po) {
        return ApiResult.msg(service.add(po));
    }
}
