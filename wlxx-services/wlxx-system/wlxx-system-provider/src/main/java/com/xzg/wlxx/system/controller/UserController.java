package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "user")
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService service;

    @PostMapping("findByUsername/{username}")
    public ApiResult<UserPo> findByUsername(@NotBlank(message = "用户名不能为空") @PathVariable String username) {
        return ApiResult.success(service.findByUsername(username));
    }

    @PostMapping("register")
    public ApiResult<Boolean> register(@Validated @RequestBody RegisterUserDto dto) {
        return ApiResult.success(service.register(dto));
    }
}
