package com.xzg.wlxx.web.config;

import com.xzg.wlxx.web.interceptor.WlxxHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局web配置
 * <p>
 * TODO WebMvcConfigurationSupport WebMvcConfigurer 配置区别
 *
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * knife4j 资源路径配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        //registry.addResourceHandler("doc.html")
        //        .addResourceLocations("classpath*:/META-INF/resources/");
        //registry.addResourceHandler("/webjars/**")
        //        .addResourceLocations("classpath*:/META-INF/resources/webjars/");

        //registry.addResourceHandler("/systemPictures/**")
        //        .addResourceLocations("file:" + System.getProperty("user.dir") + File.separator + "uploadFile" + File.separator + "systemPictures" + File.separator);
        //registry.addResourceHandler("/uploadFile/pluginFiles/logo/**")
        //        .addResourceLocations("file:" + System.getProperty("user.dir") + File.separator + "uploadFile" + File.separator + "pluginFiles" + File.separator + "logo" + File.separator);
        //
        //registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        //registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WlxxHandlerInterceptor());
    }


}
