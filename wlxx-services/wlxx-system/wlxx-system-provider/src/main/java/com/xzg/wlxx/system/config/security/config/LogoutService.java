package com.xzg.wlxx.system.config.security.config;


import cn.hutool.http.Header;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenService tokenService;

    private final ObjectMapper objectMapper;

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
        final String authHeader = request.getHeader(Header.AUTHORIZATION.getValue());
        final String jwt;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        var storedToken = tokenService.lambdaQuery()
                .eq(TokenPo::getToken, jwt)
                .eq(TokenPo::getExpired, false)
                .eq(TokenPo::getRevoked, false)
                .oneOpt()
                .orElse(null);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenService.saveOrUpdate(storedToken);
            SecurityContextHolder.clearContext();
            var result = ApiResult.success("登出成功");
            try {
                objectMapper.writeValue(response.getOutputStream(), result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            var result = ApiResult.failure("access_token 错误");
            try {
                objectMapper.writeValue(response.getOutputStream(), result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
