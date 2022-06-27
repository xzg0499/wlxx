//package com.xzg.wlxx.common.core.config;
//
//import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.util.Date;
//
///**
// * @author xzgan
// * @date 2022/6/7
// * @since jdk1.8
// */
//@Configuration
//public class WlxxDateConvertCustoms implements Jackson2ObjectMapperBuilderCustomizer {
//
//    /**
//     * 注册全局类型处理器
//     * @param jacksonObjectMapperBuilder the JacksonObjectMapperBuilder to customize
//     */
//    @Override
//    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
//        jacksonObjectMapperBuilder.deserializerByType(
//                LocalDateTime.class
//                ,new DateDeserializers.DateDeserializer(
//                        DateDeserializers.DateDeserializer.instance
//                        , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                        , null));
//    }
//}