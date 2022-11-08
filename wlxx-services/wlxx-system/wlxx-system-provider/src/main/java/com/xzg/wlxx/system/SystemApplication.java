package com.xzg.wlxx.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 系统管理，启动类
 *
 * @author xzgang0499
 * @date 2022-01-16
 * @since jdk1.8
 */
@MapperScan("com.xzg.wlxx.system.mapper")
@SpringBootApplication
@ComponentScan(value = {"com.xzg.wlxx.common.core"})
// @ComponentScan(excludeFilters = @ComponentScan.Filter(
//         type = FilterType.REGEX, pattern = "com.xzg.wlxx.common.core.base.BaseController"
// ))
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xzg.wlxx.system.**"})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
