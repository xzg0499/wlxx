package com.xzg.wlxx.web.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author XiaoZG
 */
@Slf4j
public class WlxxInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===interceptor {}", request.getRequestURI());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
