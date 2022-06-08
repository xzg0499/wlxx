package com.xzg.wlxx.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xzgan
 * @date 2022/6/7
 * @since jdk1.8
 */
@MapperScan("com.xzg.wlxx.user.mapper")
@SpringBootApplication(scanBasePackages = {"com.xzg.wlxx.**"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xzg.**"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
