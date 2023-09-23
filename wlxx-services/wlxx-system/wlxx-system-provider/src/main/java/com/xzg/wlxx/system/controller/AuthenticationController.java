package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.config.security.auth.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "auth")
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "注册")
    public ApiResult<?> register(@RequestBody UserDto dto) {
        return authenticationService.register(dto);
    }

    @PostMapping("/authentication")
    @Operation(summary = "认证")
    public ApiResult<?> authenticate(@RequestBody UserDto dto) {
        return authenticationService.authenticate(dto);
    }

    @PostMapping("/refresh")
    @Operation(summary = "刷新 Token")
    public ApiResult<?> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return authenticationService.refreshToken(request, response);
    }
}
