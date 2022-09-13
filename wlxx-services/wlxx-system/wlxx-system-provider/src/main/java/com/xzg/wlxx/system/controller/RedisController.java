package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Redis
 * @author xzgan
 * @date 2022/6/7
 * @since jdk1.8
 */
@Api(tags = "测试redis")
@RestController
@RequestMapping("/redis")
public class RedisController extends BaseController {
    @Autowired
    RedisUtil redisUtil;

    @ApiOperation("demo")
    @GetMapping("/demo")
    public void demo(String param){
        redisUtil.set("wlxx:demo:"+param,param);
    }
}
