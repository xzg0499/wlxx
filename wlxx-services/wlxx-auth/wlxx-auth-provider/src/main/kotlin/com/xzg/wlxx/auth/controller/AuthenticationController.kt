package com.xzg.wlxx.auth.controller

import com.xzg.wlxx.auth.config.security.auth.*
import com.xzg.wlxx.common.base.ApiResult
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "auth")
@RequestMapping("auth")
@RequiredArgsConstructor
class AuthenticationController {
    private val authenticationService: AuthenticationService? = null
    @PostMapping("/register")
    @Operation(summary = "注册")
    fun register(@RequestBody dto: AuthenticationDto): ApiResult<*>? {
        return authenticationService!!.register(dto)
    }

    @PostMapping("/authenticate")
    @Operation(summary = "认证")
    fun authenticate(@RequestBody dto: AuthenticationDto): ApiResult<*>? {
        return authenticationService!!.authenticate(dto)
    }

    @PostMapping("/refresh")
    @Operation(summary = "刷新 Token")
    @Throws(IOException::class)
    fun refreshToken(request: HttpServletRequest, response: HttpServletResponse?): ApiResult<*>? {
        return authenticationService!!.refreshToken(request, response)
    }
}
