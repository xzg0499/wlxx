package com.xzg.wlxx.common.core.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.xzg.wlxx.common.core.serializable.IPageDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * open feign 序列化
     * @param converters a list to add message converters to (initially an empty list)
     */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());

//        converters.add(fastJsonHttpMessageConverter());

        super.configureMessageConverters(converters);
    }

//    @Bean
//    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        List<MediaType> mediaTypes = new ArrayList<>(16);
//        mediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        mediaTypes.add(MediaType.APPLICATION_CBOR);
//        mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        mediaTypes.add(MediaType.APPLICATION_JSON);
//        mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        FastJsonConfig config=new FastJsonConfig();
//
//        config.setCharset(StandardCharsets.UTF_8);
//        config.setDateFormat("yyyy-mm-dd hh:mm:ss");
//
//        converter.setFastJsonConfig(config);
//        converter.setDefaultCharset(StandardCharsets.UTF_8);
//        converter.setSupportedMediaTypes(mediaTypes);
//        return converter;
//    }


    /**
     * 注册序列化转换器，处理IPage类型
     * @return
     */
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper mapper = new ObjectMapper();
////        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(IPage.class, new IPageDeserializer(IPage.class));
////        module.addDeserializer(Res.class, new ResDeserializer(Res.class));
//        mapper.registerModule(module);
//
//        //json中多余的参数不报错，不想要可以改掉
////        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////        //设置全局的时间转化
////        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        mapper.setDateFormat(smt);
////        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));//解决时区差8小时问题
//
//        //设置中文编码格式
////        List<MediaType> list = new ArrayList<MediaType>();
////        list.add(MediaType.APPLICATION_JSON_UTF8);
////        converter.setSupportedMediaTypes(list);
//
//
//        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_OCTET_STREAM));
//        converter.setObjectMapper(mapper);
//        return converter;
//    }
}
