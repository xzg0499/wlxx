package com.xzg.wlxx.web.config;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局knife4j配置
 *
 * @author xzgang0499
 * @date 2021-12-27
 * @since jdk1.8
 */
@Configuration

//@EnableSwagger2
public class Knife4jConfiguration {

    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().forEach(tag -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0, 100));
                    tag.setExtensions(map);
                });
            }
            if (openApi.getPaths() != null) {
                openApi.addExtension("x-test123", "333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1, 100));
            }

        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("XXX用户系统API")
                        .version("1.0")

                        .description("Knife4j集成springdoc-openapi示例")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }

    //@Bean
    //public Docket createRestApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo())
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage("com.xzg.wlxx"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}
    //
    //private ApiInfo apiInfo() {
    //    return new ApiInfoBuilder()
    //            .title("wlxx")
    //            .description("wlxx")
    //            .termsOfServiceUrl("http://localhost:8999/")
    //            .contact(new Contact("", "", "xzgang0499@qq.com"))
    //            .version("1.0")
    //            .build();
    //}
}
