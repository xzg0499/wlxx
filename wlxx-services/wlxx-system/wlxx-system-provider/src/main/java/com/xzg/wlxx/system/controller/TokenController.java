package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "token")
@RequestMapping("token")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService service;

    @PostMapping("findToken")
    public ApiResult<TokenPo> findToken(@RequestBody TokenPo tokenPo) {
        return ApiResult.success(service.lambdaQuery(tokenPo).one());
    }

    @PostMapping("saveOrUpdate")
    public ApiResult<Boolean> saveOrUpdate(@RequestBody TokenPo po) {
        return ApiResult.success(service.saveOrUpdate(po));
    }
}
