package com.xzg.wlxx.web.config

import com.xzg.wlxx.web.config.feign.WlxxDecoder
import feign.codec.Decoder
import feign.optionals.OptionalDecoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.xzg.wlxx.**.client.feign"])
class FeignConfiguration {
    @Autowired
    private val messageConvertersObjectFactory: ObjectFactory<HttpMessageConverters>? = null
    @Bean
    fun decoder(objectFactory: ObjectProvider<HttpMessageConverterCustomizer?>?): Decoder {
        return OptionalDecoder(
            ResponseEntityDecoder(
                WlxxDecoder(
                    SpringDecoder(
                        messageConvertersObjectFactory,
                        objectFactory
                    )
                )
            )
        )
    }
}
