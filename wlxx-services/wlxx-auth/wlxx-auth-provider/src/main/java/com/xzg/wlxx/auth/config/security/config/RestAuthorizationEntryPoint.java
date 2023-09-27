package com.xzg.wlxx.auth.config.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzg.wlxx.common.base.ApiResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        // 通过response设置编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置ContentType
        response.setContentType("application/json");

        // 输出流
        PrintWriter out = response.getWriter();

        ApiResult bean = ApiResult.builder()
                .code(401)
                .msg("尚未登录，请登录！")
                .build();
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}