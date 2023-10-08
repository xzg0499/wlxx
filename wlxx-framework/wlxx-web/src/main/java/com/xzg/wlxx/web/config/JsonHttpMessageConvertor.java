package com.xzg.wlxx.web.config;

/**
 * 接口参数序列化
 *
 * @author XiaoZG
 */

//@Configuration
//@RequiredArgsConstructor
public class JsonHttpMessageConvertor {

//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss.SSS}")
//    private String dateFormat;
//
//    @Bean
//    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        SimpleModule module = new SimpleModule();
//        // Long 转换成 String 类型，JS 中 Long 会丢失精度
//        module.addSerializer(Long.class, ToStringSerializer.instance);
//        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        objectMapper.registerModule(module);
//        JavaTimeModule timeModule = new JavaTimeModule();
//        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateFormat)));
//        objectMapper.registerModule(timeModule);
//        objectMapper.setDateFormat(new SimpleDateFormat(dateFormat));
//        return objectMapper;
//    }
}

