package com.xzg.wlxx.web.config;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import com.xzg.wlxx.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

/**
 * @author XiaoZG
 */
@Slf4j
public class WlxxInterceptor implements HandlerInterceptor {

    public static final String[] WHITE_LIST = {
            "/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/doc.html",
            "/webjars/**",
            "/swagger-ui.html",
            "/favicon.ico"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===interceptor {}", request.getRequestURI());
        log.debug("===accessToken {}", request.getHeader(Header.AUTHORIZATION.getValue()));
        String accessToken = request.getHeader(Header.AUTHORIZATION.getValue());
        String uri = request.getRequestURI();
        String xtype = request.getHeader("x-type");
        if (Arrays.stream(WHITE_LIST).anyMatch(s -> uri.startsWith(s.replaceAll("\\*\\*$", "")))) {
            return true;
        }
        if (StrUtil.equals("feign", xtype)) {
            return true;
        }
        // TODO knife4j认证转换jwt
        // Interceptor 在gateway不生效
        if (accessToken.startsWith("Basic")) {
            String decode = Base64Decoder.decodeStr("eHpnOnhpYW8=");
            String username = decode.split(":")[0];
            String password = decode.split(":")[1];
            log.debug("username: {} password: {}", username, password);
            return true;
        }
        if (StrUtil.isBlank(accessToken)) {
            throw new BusinessException("请登录");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    public static void main(String[] args) {
        System.out.println(Base64Decoder.decodeStr("eHpnOnhpYW8="));
    }
}
