package com.xzg.wlxx.web.config.feign

import cn.hutool.core.lang.ParameterizedTypeImpl
import com.xzg.wlxx.common.base.ApiResult
import feign.FeignException
import feign.Response
import feign.codec.DecodeException
import feign.codec.Decoder
import java.io.IOException
import java.lang.reflect.Type

class WlxxDecoder(private val decoder: Decoder) : Decoder {
    /**
     * 处理 feign 返回类型，ApiResult-->?
     */
    @Throws(IOException::class, DecodeException::class, FeignException::class)
    override fun decode(response: Response, type: Type): Any {
        val method = response.request().requestTemplate().methodMetadata().method()
        val isResult = method.returnType != ApiResult::class.java
        if (isResult) {
            // TODO ParameterizedTypeImpl 类无法使用
            val resultType =
                ParameterizedTypeImpl(arrayOf(type), ApiResult::class.java.declaringClass, ApiResult::class.java)
            val (_, _, data) = decoder.decode(response, resultType) as ApiResult<*>
            return data!!
        }
        throw RuntimeException("类型无法转换")
    }
}
