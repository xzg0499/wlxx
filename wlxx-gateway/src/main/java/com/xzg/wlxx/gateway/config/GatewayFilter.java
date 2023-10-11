package com.xzg.wlxx.gateway.config;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzg.wlxx.common.base.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.xzg.wlxx.web.config.WlxxInterceptor.WHITE_LIST;

/**
 * @author XiaoZG
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GatewayFilter implements GlobalFilter, Ordered {

    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.debug("=== filter {}", exchange.getRequest().getPath());
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String accessToken = getHeader(headers, HttpHeaders.AUTHORIZATION);
        String uri = exchange.getRequest().getPath().toString();
        String xtype = getHeader(headers, "x-type");
        if (Arrays.stream(WHITE_LIST).anyMatch(s ->
                uri.startsWith(s.replaceAll("\\*\\*$", ""))
                        || uri.replaceAll("^/.+?/", "/").startsWith(s.replaceAll("\\*\\*$", ""))
        )
        ) {
            return chain.filter(exchange);
        }
        if (StrUtil.equals("feign", xtype)) {
            return chain.filter(exchange);
        }
        // TODO knife4j认证转换jwt
        // Interceptor 在gateway不生效
        if (StrUtil.startWith(accessToken, "Basic")) {
            String decode = Base64Decoder.decodeStr(accessToken.replaceAll("^Basic ", ""));
            String username = decode.split(":")[0];
            String password = decode.split(":")[1];
            log.debug("username: {} password: {}", username, password);
            return chain.filter(exchange);
        }
        if (StrUtil.isBlank(accessToken)) {
            return Mono.defer(() -> {
                var result = ApiResult.failure("请登录");
                ServerHttpResponse response = exchange.getResponse();
                byte[] bytes = new byte[0];
                try {
                    bytes = objectMapper.writeValueAsBytes(result);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                var buffer = response.bufferFactory().wrap(bytes);
                return response.writeWith(Flux.just(buffer));
            });
        }
        return chain.filter(exchange);
    }

    private static String getHeader(HttpHeaders headers, String key) {
        List<String> list = headers.get(key);
        AtomicReference<String> value = new AtomicReference<>();
        if (CollUtil.isEmpty(list)) {
            return value.get();
        }
        list.stream().findFirst().ifPresent(value::set);
        return value.get();
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
