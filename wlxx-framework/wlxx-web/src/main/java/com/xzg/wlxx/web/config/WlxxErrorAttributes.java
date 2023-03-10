package com.xzg.wlxx.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Set;

/**
 * @author xzgan
 * @date 2023/3/9
 */
@Component
@Slf4j
public class WlxxErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.remove("timestamp");
        errorAttributes.remove("path");
        errorAttributes.remove("timestamp");


        Set<String> strings = errorAttributes.keySet();
        for (String it : strings) {
            Object o = errorAttributes.get(it);
            log.info("key : " + it, "value : " + o);
        }

        return errorAttributes;
    }
}
