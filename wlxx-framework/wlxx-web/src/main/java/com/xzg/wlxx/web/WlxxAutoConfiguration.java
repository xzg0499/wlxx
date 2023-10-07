package com.xzg.wlxx.web;

import com.xzg.wlxx.web.config.*;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoZG
 */
@Configuration(proxyBeanMethods = false)
@ImportAutoConfiguration({MybatisPlusConfiguration.class
        , Knife4jConfiguration.class
        , ExceptionController.class
        , WlxxErrorAttributes.class
        , FeignConfiguration.class})
public class WlxxAutoConfiguration {
}
