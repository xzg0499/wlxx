package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "user")
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService service;

    @PostMapping("get")
    public ApiResult<UserPo> get() {
        return success(service.list().stream().findFirst().get());
    }
}
