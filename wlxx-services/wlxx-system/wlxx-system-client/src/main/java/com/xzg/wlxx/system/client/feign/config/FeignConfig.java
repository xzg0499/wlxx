package com.xzg.wlxx.system.client.feign.config;

import com.xzg.wlxx.system.client.feign.impl.DictFeignImpl;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class FeignConfig {
//    @Bean
//    public DictFeignImpl dictFeign(){
//        return new DictFeignImpl();
//    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Bean
//    public Decoder decoder(){
//        return new JacksonDecoder();
//    }
//
//    @Bean
//    public Encoder encoder() {
//        return new JacksonEncoder();
//    }
}
