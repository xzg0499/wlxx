package com.xzg.wlxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@MapperScan(basePackages = {"com.xzg.wlxx.module.*.mapper"})
public class WlxxApplication {

	public static void main(String[] args) {
//		TODO 配置banner输出Application version
		ConfigurableApplicationContext context = SpringApplication.run(WlxxApplication.class, args);
		ConfigurableEnvironment environment = new StandardReactiveWebEnvironment();
	}

}
