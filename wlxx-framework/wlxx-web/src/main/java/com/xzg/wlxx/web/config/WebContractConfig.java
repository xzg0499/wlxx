package com.xzg.wlxx.web.config;

import org.springframework.cloud.openfeign.support.SpringMvcContract;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
//@Configuration
@Deprecated
public class WebContractConfig extends SpringMvcContract {

    //@Override
    //public MethodMetadata parseAndValidateMetadata(Class<?> targetType, Method method) {
    //    MethodMetadata methodMetadata = super.parseAndValidateMetadata(targetType, method);
    //    Type returnType = methodMetadata.returnType();
    //    if (returnType instanceof ParameterizedType && ((ParameterizedType) returnType).getRawType() == IPage.class) {
    //        methodMetadata.returnType(Page.class);
    //    }
    //    return methodMetadata;
    //}
}
