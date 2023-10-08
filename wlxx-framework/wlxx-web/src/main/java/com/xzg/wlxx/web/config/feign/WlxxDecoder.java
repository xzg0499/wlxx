package com.xzg.wlxx.web.config.feign;

import cn.hutool.core.lang.ParameterizedTypeImpl;
import com.xzg.wlxx.common.base.ApiResult;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class WlxxDecoder implements Decoder {
    private final Decoder decoder;

    public WlxxDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    /**
     * 处理 feign 返回类型，ApiResult<?>-->?
     */
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Method method = response.request().requestTemplate().methodMetadata().method();
        boolean isResult = method.getReturnType() != ApiResult.class;
        if (isResult) {
            // TODO ParameterizedTypeImpl 类无法使用
            ParameterizedTypeImpl resultType = new ParameterizedTypeImpl(new Type[]{type}, ApiResult.class.getDeclaringClass(), ApiResult.class);
            ApiResult<?> result = (ApiResult<?>) this.decoder.decode(response, resultType);
            return result.getData();
        }
        throw new RuntimeException("类型无法转换");
    }
}
