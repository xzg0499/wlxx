package com.xzg.wlxx.flowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 全局knife4j配置
 *
 * @author xzgang0499
 * @date 2021-12-27
 * @since jdk1.8
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("wlxx")
                .description("wlxx")
                .termsOfServiceUrl("http://localhost:8999/")
                .contact(new Contact("", "", "xzgang0499@qq.com"))
                .version("1.0")
                .build();
    }
}
