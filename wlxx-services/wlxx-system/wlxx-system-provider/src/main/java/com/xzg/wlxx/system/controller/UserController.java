package com.xzg.wlxx.system.controller;

import cn.hutool.core.util.StrUtil;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
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

    @PostMapping("/login")
    public ApiResult<String> login(String username, String password) {
        return success(StrUtil.format("{} is login succeed!!!", username));
    }

    @PostMapping("/no-login")
    public ApiResult<String> noLogin(String username, String password) {
        return success(StrUtil.format("{} is logout!!!", username));
    }
}
