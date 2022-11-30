package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.response.Result;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "用户", value = "用户")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController extends BaseController {

    private final IUserService service;

    @ApiOperation("添加用户")
    @PostMapping("add")
    public Result add(@RequestBody @Validated UserPo po) {
        if (service.add(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("search-page")
    public Result searchPage(@RequestBody UserParam param) {
        return BaseRes.success(service.queryPage(param));
    }
}
