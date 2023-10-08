package com.xzg.wlxx.auth.config.security.config

import cn.hutool.http.Header
import com.fasterxml.jackson.databind.ObjectMapper
import com.xzg.wlxx.common.base.ApiResult.Companion.message
import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.client.feign.TokenProvider
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.LogoutHandler
import org.springframework.stereotype.Service
import java.io.IOException

@Service
@RequiredArgsConstructor
class LogoutService : LogoutHandler {
    private val tokenService: TokenProvider? = null
    private val objectMapper: ObjectMapper? = null
    override fun logout(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val authHeader = request.getHeader(Header.AUTHORIZATION.value)
        val jwt: String
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return
        }
        jwt = authHeader.substring(7)
        val storedToken = tokenService!!.findToken(
            TokenPo(token = jwt, expired = false, revoked = false)
        )
        if (storedToken != null) {
            storedToken.expired = true
            storedToken.revoked = true
            tokenService.saveOrUpdate(storedToken)
            SecurityContextHolder.clearContext()
            handleResult(response, "登出成功")
        } else {
            handleResult(response, "access_token 错误")
        }
    }

    fun handleResult(response: HttpServletResponse, msg: String?) {
        val result = message<Any>(msg)
        try {
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            objectMapper!!.writeValue(response.outputStream, result)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}
