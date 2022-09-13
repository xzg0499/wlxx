package com.xzg.wlxx.system;

import com.xzg.wlxx.common.core.base.BaseController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统管理，启动类
 * @author xzgang0499
 * @date 2022-01-16
 * @since jdk1.8
 */
@MapperScan("com.xzg.wlxx.system.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xzg.wlxx.system.**"})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
