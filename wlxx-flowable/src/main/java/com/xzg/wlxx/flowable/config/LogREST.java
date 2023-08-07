package com.xzg.wlxx.flowable.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xzgan
 * @date 2023/7/6
 */
@Component
@Slf4j
public class LogREST {

    @Autowired
    WebApplicationContext applicationContext;

    @Bean
    public void printREST() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 拿到Handler适配器中的全部方法
        Map<RequestMappingInfo, HandlerMethod> methodMap = mapping.getHandlerMethods();
        List<String> urlList = new ArrayList<>();
        for (RequestMappingInfo info : methodMap.keySet()) {

            Set<String> urlSet = info.getPatternsCondition().getPatterns();
            // 获取全部请求方式
            Set<RequestMethod> Methods = info.getMethodsCondition().getMethods();
            for (String url : urlSet) {
                // 加上自己的域名和端口号，就可以直接调用
                urlList.add("http://localhost:XXXX" + url);
            }
        }

        urlList.forEach(log::info);
    }
}
