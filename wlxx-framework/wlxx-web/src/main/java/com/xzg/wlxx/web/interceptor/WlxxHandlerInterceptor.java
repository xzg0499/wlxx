package com.xzg.wlxx.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author xzgan
 * @date 2023/3/8
 */
@Component
public class WlxxHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(@NotNull HttpServletRequest request
            , @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        handleErrorRequest(request, response, handler);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    public void handleErrorRequest(HttpServletRequest request, HttpServletResponse response
            , Object handler) {
        //if (handler instanceof BasicErrorController) {
        //    throw new BusinessException("测试404");
        //}
    }

    @Override
    public void afterCompletion(HttpServletRequest request, @NotNull HttpServletResponse response
            , @NotNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        //if (request.getRequestURI().equals("/error")) {
        //    throw new BusinessException("");
        //}
    }
}
