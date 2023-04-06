package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.service.IOrgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
@RestController
@Tag(name = "组织结构管理")
@RequestMapping("org")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrgController {

    private final IOrgService service;

    @Operation(summary = "新增")
    @PostMapping("add")
    public RestApiResult add(@RequestBody @Validated Org po) {
        return ApiResult.msg(service.add(po));
    }

    @Operation(summary = "修改")
    @PostMapping("edit")
    public RestApiResult edit(@RequestBody Org po) {
        return ApiResult.msg(service.edit(po));
    }

    /**
     * FIXME restful接口不能传空
     */
    @Operation(summary = "获取组织结构")
    @GetMapping("get-all")
    public RestApiResult<List<OrgVo>> getAll() {
        return ApiResult.success(service.get(null));
    }

    @Operation(summary = "获取组织结构")
    @GetMapping("get/{id}")
    public RestApiResult<List<OrgVo>> get(@PathVariable(value = "id", required = false) Long id) {
        return ApiResult.success(service.get(id));
    }
}
