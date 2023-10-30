package com.xzg.wlxx.front;

import com.xzg.wlxx.web.WlxxAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author XiaoZG
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, WlxxAutoConfiguration.class})
public class FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }
}
