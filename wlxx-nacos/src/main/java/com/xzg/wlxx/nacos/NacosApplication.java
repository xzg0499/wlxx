package com.xzg.wlxx.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: 肖志刚
 * @Date: 2021/10/28 15:08
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class,args);
    }
}
