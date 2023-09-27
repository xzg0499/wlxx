package com.xzg.wlxx.web;

import com.xzg.wlxx.web.config.ExceptionController;
import com.xzg.wlxx.web.config.FeignConfiguration;
import com.xzg.wlxx.web.config.Knife4jConfiguration;
import com.xzg.wlxx.web.config.MybatisPlusConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoZG
 */
@Configuration(proxyBeanMethods = false)
@ImportAutoConfiguration({MybatisPlusConfiguration.class
        , Knife4jConfiguration.class
        , ExceptionController.class
        , FeignConfiguration.class})
public class WlxxAutoConfiguration {
}
