package com.xzg.wlxx.web.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import feign.MethodMetadata;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class WebContractConfig extends SpringMvcContract {

    @Override
    public MethodMetadata parseAndValidateMetadata(Class<?> targetType, Method method) {
        MethodMetadata methodMetadata = super.parseAndValidateMetadata(targetType, method);
        Type returnType = methodMetadata.returnType();
        if (returnType instanceof ParameterizedType && ((ParameterizedType) returnType).getRawType() == IPage.class) {
            methodMetadata.returnType(Page.class);
        }
        return methodMetadata;
    }
}
