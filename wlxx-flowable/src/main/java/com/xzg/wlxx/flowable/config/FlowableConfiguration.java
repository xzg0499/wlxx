package com.xzg.wlxx.flowable.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author xzgan
 * @date 2023/7/15
 */
@Configuration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
// Makes sure that this configuration will be processed last by Spring Boot
@ConditionalOnBean(type = "org.flowable.engine.ProcessEngine")
// The configuration will only be used when the ProcessEngine bean is present
public class FlowableConfiguration {


    @Configuration
    @ComponentScan("com.your.own.package.beans")
    public static class ComponentScanConfiguration {
        // This class is needed in order to conditionally perform the component scan (i.e. when the ProcessEngine bean is present)
        // It is an optional class, in case you don't need component scanning then you don't need to do this
    }

    //@Bean
    //public CustomBean customBean() {
    //    // create your bean
    //}

    @Bean
    public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customProcessEngineConfigurationConfigurer() {
        return engineConfiguration -> {
            // You can use this to add extra configuration to the process engine

        };
    }
}
