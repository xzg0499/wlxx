package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.response.RestResult;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户管理", value = "用户管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController extends BaseController {

    private final IUserService service;

    @ApiOperation("添加用户")
    @PostMapping("add")
    public RestResult add(@RequestBody @Validated UserPo po) {
        if (service.add(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("search-page")
    public RestResult searchPage(@RequestBody UserParam param) {
        return BaseRes.success(service.search(param));
    }

    @ApiOperation("启用")
    @PutMapping("enabled/{id}")
    public RestResult enabled(@PathVariable(name = "id")Long id){
        if(service.enabled(id,true)){
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("启用")
    @PutMapping("disabled/{id}")
    public RestResult disabled(@PathVariable(name = "id")Long id){
        if(service.enabled(id,false)){
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public RestResult del(@PathVariable Long id){
        if(service.removeById(id)){
            return BaseRes.success();
        }
        return BaseRes.failure();
    }
}
