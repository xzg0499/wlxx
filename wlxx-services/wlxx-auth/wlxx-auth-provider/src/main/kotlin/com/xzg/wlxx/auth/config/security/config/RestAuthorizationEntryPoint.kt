package com.xzg.wlxx.auth.config.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.xzg.wlxx.common.base.ApiResult.Companion.message
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RestAuthorizationEntryPoint : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {

        // 通过response设置编码格式
        response.characterEncoding = "UTF-8"
        // 设置ContentType
        response.contentType = "application/json"

        // 输出流
        val out = response.writer
        val bean = message(code = 401, msg = "尚未登录，请登录！", null, null)
        out.write(ObjectMapper().writeValueAsString(bean))
        out.flush()
        out.close()
    }
}
