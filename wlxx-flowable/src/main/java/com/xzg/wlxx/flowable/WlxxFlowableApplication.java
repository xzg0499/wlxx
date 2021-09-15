package com.xzg.wlxx.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @author xzgan
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WlxxFlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(WlxxFlowableApplication.class, args);
    }

}
