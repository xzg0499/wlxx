package com.xzg.wlxx.user.controller;

import com.xzg.wlxx.common.core.pojo.entity.BaseController;
import com.xzg.wlxx.common.core.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
@Api("用户")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/getUser/{id}")
    @ApiOperation("测试")
    public ResponseData getUser(@PathVariable("id")String id){
        return success("Hello "+id);
    }
}
