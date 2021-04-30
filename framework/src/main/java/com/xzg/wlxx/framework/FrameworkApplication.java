package com.xzg.wlxx.framework;

import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,SecurityAutoConfiguration.class, org.activiti.spring.boot.SecurityAutoConfiguration.class, DataSourceProcessEngineAutoConfiguration.class})
public class FrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}

}
