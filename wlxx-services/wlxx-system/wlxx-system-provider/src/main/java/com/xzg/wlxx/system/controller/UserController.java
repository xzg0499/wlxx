package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@RestController
@RequestMapping("user")
@Tag(name = "用户管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final IUserService service;

    @Operation(summary = "添加用户")
    @PostMapping("add")
    public RestApiResult add(@RequestBody @Validated UserPo po) {
        if (service.add(po)) {
            return ApiResult.success();
        }
        return ApiResult.failure();
    }

    @Operation(summary = "分页查询")
    @PostMapping("search-page")
    public RestApiResult searchPage(@RequestBody UserParam param) {
        return ApiResult.success(service.search(param));
    }

    @Operation(summary = "启用")
    @PutMapping("enabled/{id}")
    public RestApiResult enabled(@PathVariable(name = "id") Long id) {
        if (service.enabled(id, true)) {
            return ApiResult.success();
        }
        return ApiResult.failure();
    }

    @Operation(summary = "启用")
    @PutMapping("disabled/{id}")
    public RestApiResult disabled(@PathVariable(name = "id") Long id) {
        if (service.enabled(id, false)) {
            return ApiResult.success();
        }
        return ApiResult.failure();
    }

    @Operation(summary = "删除")
    @DeleteMapping("del/{id}")
    public RestApiResult del(@PathVariable Long id) {
        if (service.removeById(id)) {
            return ApiResult.success();
        }
        return ApiResult.failure();
    }
}
