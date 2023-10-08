package com.xzg.wlxx.system.config

import com.alibaba.fastjson2.support.config.FastJsonConfig
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.charset.Charset

/**
 * @author XiaoZG
 */
@Configuration
class WlxxWebMvcConfigurer : WebMvcConfigurer {
    @Value("\${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss.SSS}")
    private val dateFormat: String? = null

    //    @Override
    //    public void addInterceptors(InterceptorRegistry registry) {
    //        WebMvcConfigurer.super.addInterceptors(registry);
    //    }
    override fun configureMessageConverters(converters: List<HttpMessageConverter<*>?>) {
//        WebMvcConfigurer.super.configureMessageConverters(converters);
        val config = FastJsonConfig()
        config.dateFormat = dateFormat
        config.charset = Charset.defaultCharset()
        val converter = FastJsonHttpMessageConverter()
        converter.fastJsonConfig = config
        converters.plus(converter)
    } //    @Override
    //    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
    //        ObjectMapper objectMapper = converter.getObjectMapper();
    //        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //        SimpleModule module = new SimpleModule();
    //        // Long 转换成 String 类型，JS 中 Long 会丢失精度
    //        module.addSerializer(Long.class, ToStringSerializer.instance);
    //        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
    //        objectMapper.registerModule(module);
    //        JavaTimeModule timeModule = new JavaTimeModule();
    //        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    //        objectMapper.registerModule(timeModule);
    //        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
    //        converters.add(0, converter);
    //    }
}
