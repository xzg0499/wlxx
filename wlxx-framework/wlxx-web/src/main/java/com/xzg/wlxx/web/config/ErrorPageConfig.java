package com.xzg.wlxx.web.config;

import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;

/**
 * @author xzgan
 * @date 2023/3/8
 */
//@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages();
    }
}
