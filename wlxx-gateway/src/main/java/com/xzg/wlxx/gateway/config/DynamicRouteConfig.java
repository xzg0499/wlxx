//package com.xzg.wlxx.gateway.config;
//
//import com.alibaba.cloud.nacos.NacosConfigManager;
//import com.alibaba.cloud.nacos.NacosConfigProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
////@ConditionalOnProperty(prefix = "", name = "", havingValue = "")
//public class DynamicRouteConfig {
//    @Autowired
//    private ApplicationEventPublisher publisher;
//
//
//    @Configuration
//    public class NacosDynamicoute {
//        @Autowired
//        private NacosConfigProperties properties;
//        @Autowired
//        private NacosConfigManager nacosConfigManager;
//
//        @Bean
//        public NacosRouteDefinitionRepository nacosRouteDefinitionRepository() {
//            return new NacosRouteDefinitionRepository(publisher, nacosConfigManager);
//        }
//    }
//}
