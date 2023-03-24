package com.xzg.wlxx.web.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一封装返回结果
 * <p>
 * 可用于区分openfeigin调用和前端调用
 *
 * @author xzgan
 * @date 2023/3/14
 */
@RestControllerAdvice
public class WlxxResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType
            , MediaType selectedContentType
            , Class<? extends HttpMessageConverter<?>> selectedConverterType
            , ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}
