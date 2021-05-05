package com.xzg.wlxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {})
public class WlxxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlxxApplication.class, args);
	}

}
