package com.xzg.wlxx.web.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 全局feign配置
 *
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class FeignGlobalConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
