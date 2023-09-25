package com.xzg.wlxx.system.config.security.config;


import cn.hutool.http.Header;
import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenService tokenService;

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
                .eq(TokenPo::getToken, jwt).oneOpt()
                .orElse(null);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenService.saveOrUpdate(storedToken);
            SecurityContextHolder.clearContext();
        }
    }
}
