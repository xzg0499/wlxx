package com.xzg.wlxx.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzgang0499
 * @date 2022-01-16
 * @since jdk1.8
 */
@MapperScan("com.xzg.wlxx.system.mapper")
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
