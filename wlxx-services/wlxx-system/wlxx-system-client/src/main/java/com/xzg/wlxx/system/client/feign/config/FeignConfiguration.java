package com.xzg.wlxx.system.client.feign.config;

import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.xzg.wlxx.**.client.feign")
public class FeignConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    @Bean
    public Decoder decoder(ObjectProvider<HttpMessageConverterCustomizer> objectFactory) {
        return new OptionalDecoder(new ResponseEntityDecoder(new WlxxDecoder(new SpringDecoder(messageConvertersObjectFactory, objectFactory))));
    }
}
