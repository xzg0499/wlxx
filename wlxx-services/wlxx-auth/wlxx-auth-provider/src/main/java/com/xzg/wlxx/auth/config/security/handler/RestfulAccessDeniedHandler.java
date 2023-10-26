package com.xzg.wlxx.auth.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzg.wlxx.auth.entity.base.ApiAuthCode;
import com.xzg.wlxx.common.base.ApiResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;


@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        // 通过response设置编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置ContentType
        response.setContentType("application/json");
        // 输出流
        PrintWriter out = response.getWriter();

        ApiResult<?> bean = ApiResult.builder()
                .code(ApiAuthCode.NO_AUTH.code)
                .msg(ApiAuthCode.NO_AUTH.msg)
                .build();
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
