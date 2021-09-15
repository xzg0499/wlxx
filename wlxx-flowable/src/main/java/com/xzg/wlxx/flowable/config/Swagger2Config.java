package com.xzg.wlxx.flowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 肖志刚
 * @Date: 2020/5/23 10:06
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API接口文档")
                .description("Wlxx App")
                .version("1.0.0")
                .build();

    }

    @Bean
    public Docket createRestApi(Environment environment) {

        // 设置要显示的swagger 环境
        Profiles p = Profiles.of("dev","test");

        // 通过environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean b = environment.acceptsProfiles(p);

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(b)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xzg.wlxx.flowable"))
                .paths(PathSelectors.any())
                .build();
    }
}
