package com.xzg.wlxx.web.config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.xzg.wlxx.web.config.feign.FeignInterceptor;
import com.xzg.wlxx.web.config.feign.WlxxDecoder;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Import(FeignInterceptor.class)
@EnableFeignClients(basePackages = "com.xzg.wlxx.**.client.feign")
public class FeignConfiguration {

    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss.SSS}")
    private String dateFormat;

//    @Autowired
//    private ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    @Bean
    public Decoder feignDecoder(ObjectProvider<HttpMessageConverterCustomizer> objectFactory) {
        return new OptionalDecoder(new ResponseEntityDecoder(new WlxxDecoder(new SpringDecoder(feignHttpMessageConverter(), objectFactory))));
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(feignHttpMessageConverter());
    }


    private ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(this.getFastJsonConverter());
        return () -> httpMessageConverters;
    }

    private FastJsonHttpMessageConverter getFastJsonConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        List<MediaType> supportedMediaTypes = new ArrayList<>();
        MediaType mediaTypeJson = MediaType.APPLICATION_JSON;
        supportedMediaTypes.add(mediaTypeJson);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        FastJsonConfig config = new FastJsonConfig();
        config.setWriterFeatures(JSONWriter.Feature.ReferenceDetection);
        config.setDateFormat(dateFormat);
        config.setCharset(Charset.defaultCharset());
        // 序列化
        config.setWriterFeatures(JSONWriter.Feature.PrettyFormat);
        // 反序列化
        config.setReaderFeatures(
                JSONReader.Feature.FieldBased,
                JSONReader.Feature.SupportArrayToBean
        );
        converter.setFastJsonConfig(config);

        return converter;
    }
}
