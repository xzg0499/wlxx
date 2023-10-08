package com.xzg.wlxx.system.controller;

import cn.zhxu.bs.BeanSearcher;
import cn.zhxu.bs.MapSearcher;
import cn.zhxu.bs.SearchResult;
import cn.zhxu.bs.util.MapUtils;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ApiResult<Boolean> register(@RequestBody @Validated RegisterUserDto dto) {
        return ApiResult.success(service.register(dto));
    }

    private final BeanSearcher beanSearcher;
    private final MapSearcher mapSearcher;

    @GetMapping("/mapSearcher")
    public SearchResult<Map<String, Object>> mapSearcher(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return mapSearcher.search(UserPo.class, MapUtils.flat(request.getParameterMap()));
    }

    @GetMapping("/beanSearcher")
    public SearchResult<UserPo> beanSearcher(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return beanSearcher.search(UserPo.class, MapUtils.flat(request.getParameterMap()));
    }
}
