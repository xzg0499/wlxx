package com.xzg.wlxx.system.client.feign.config;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class WlxxDecoder implements Decoder {
    private Decoder decoder;

    public WlxxDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
//        Method method = response.request().requestTemplate().methodMetadata().method();
//        boolean isResult = method.getReturnType() == ApiResult.class;
//        if (isResult) {
//            ApiResult<?> result = (ApiResult<?>) this.decoder.decode(response, type);
//            return result.getData();
//        }
        type = ((ParameterizedType) type).getActualTypeArguments()[0];
        Object decodedObject = this.decoder.decode(response, type);
        return decodedObject;
//        throw new RuntimeException("类型无法转换");
    }
}
