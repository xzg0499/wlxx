package com.xzg.wlxx.web.config.feign;

import cn.hutool.core.lang.ParameterizedTypeImpl;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.exception.BusinessException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author XiaoZG
 */
@RequiredArgsConstructor
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    private final Decoder decoder;

    /**
     * 处理 HttpStatus 异常
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            ParameterizedTypeImpl resultType = new ParameterizedTypeImpl(new Type[]{new Type() {
                @Override
                public String getTypeName() {
                    return Object.class.getTypeName();
                }
            }}, ApiResult.class.getDeclaringClass(), ApiResult.class);
            ApiResult<?> result = (ApiResult<?>) this.decoder.decode(response, resultType);
            return new BusinessException(result.getMsg());
        } catch (IOException e) {
            log.error("cast error");
            return new BusinessException("cast error");
        }
    }
}
