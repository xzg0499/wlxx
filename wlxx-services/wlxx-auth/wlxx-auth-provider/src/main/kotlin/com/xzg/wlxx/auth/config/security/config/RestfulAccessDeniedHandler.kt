package com.xzg.wlxx.auth.config.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.xzg.wlxx.common.base.ApiResult
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RestfulAccessDeniedHandler : AccessDeniedHandler {
    @Throws(IOException::class, ServletException::class)
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {

        // 通过response设置编码格式
        response.characterEncoding = "UTF-8"
        // 设置ContentType
        response.contentType = "application/json"
        // 输出流
        val out = response.writer
        val bean = ApiResult.message(code = 403, msg = "您的权限不足！", null, null)
        out.write(ObjectMapper().writeValueAsString(bean))
        out.flush()
        out.close()
    }
}
