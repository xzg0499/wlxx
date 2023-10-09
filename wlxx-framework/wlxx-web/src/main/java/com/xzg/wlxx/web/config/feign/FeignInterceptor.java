package com.xzg.wlxx.web.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoZG
 */
@Configuration
@Slf4j
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        log.debug("===feignInterceptor {}", template.request().url());
        template.header("x-type", "feign");
    }
}