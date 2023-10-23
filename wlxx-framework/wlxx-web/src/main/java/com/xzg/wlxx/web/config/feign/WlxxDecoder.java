package com.xzg.wlxx.web.config.feign;

import cn.hutool.core.lang.ParameterizedTypeImpl;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.exception.BusinessException;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

@RequiredArgsConstructor
public class WlxxDecoder implements Decoder {
    private final Decoder decoder;

    /**
     * 处理 feign 返回类型，ApiResult<?>-->?
     */
    @Override
    public Object decode(Response response, Type type) {
        try {
            Method method = response.request().requestTemplate().methodMetadata().method();
            boolean isResult = method.getReturnType() != ApiResult.class;
            if (isResult) {
                ParameterizedTypeImpl resultType = new ParameterizedTypeImpl(new Type[]{type}, ApiResult.class.getDeclaringClass(), ApiResult.class);
                ApiResult<?> result = (ApiResult<?>) this.decoder.decode(response, resultType);
                if (Objects.isNull(result.getData()) && Objects.nonNull(result.getEx())) {
                    throw new RuntimeException(result.getEx().getMessage());
                }
                return result.getData();
            } else {
                return this.decoder.decode(response, type);
            }
        } catch (SecurityException | IOException | FeignException | BusinessException e) {
            throw new RuntimeException(e);
        }
//        throw new RuntimeException("类型无法转换");
    }
}
