package com.xzg.wlxx.common.core.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Configuration
public class FeignGlobalConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 自定义拦截器
     *
     * @return
     */
//    @Bean
//    public FeignAuthRequestInterceptor feignAuthRequestInterceptor(){
//        return new FeignAuthRequestInterceptor();
//    }
//    @Bean
//    public Request.Options options() {
//        return new Request.Options(5000, 5000);
//    }

//    @Bean
//    public Decoder decoder() {
//        return new JacksonDecoder();
//    }
//    @Bean
//    public Encoder encoder() {
//        return new JacksonEncoder();
//    }


//    private static final String DEFAULT_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
//
//    private static final String DEFAULT_DATE_FORMATTER = "yyyy-MM-dd";
//
//    private static final String DEFAULT_TIME_FORMATTER = "HH:mm:ss";
//
//    private static final Gson gson = GSON = new GsonBuilder()
//            .serializeNulls()
//            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (localDateTime, typeOfSrc, context) -> {
//                if (Objects.isNull(localDateTime)) {
//                    return new JsonPrimitive("");
//                }
//                return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER)));
//            })
//            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json1, typeOfT, context) -> {
//                String string = json1.getAsJsonPrimitive().getAsString();
//                if (Strings.isNullOrEmpty(string)) {
//                    return null;
//                }
//                return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER));
//            })
//            .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (localDate, type, jsonSerializationContext) -> {
//                if (Objects.isNull(localDate)) {
//                    return new JsonPrimitive("");
//                }
//                return new JsonPrimitive(localDate.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER)));
//            })
//            .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) -> {
//                String string = json.getAsJsonPrimitive().getAsString();
//                if (Strings.isNullOrEmpty(string)) {
//                    return null;
//                }
//                return LocalDate.parse(string, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER));
//            })
//            .registerTypeAdapter(LocalTime.class, (JsonSerializer<LocalTime>) (localTime, type, jsonSerializationContext) -> {
//                if (Objects.isNull(localTime)) {
//                    return new JsonPrimitive("");
//                }
//                return new JsonPrimitive(localTime.format(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER)));
//            })
//            .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) -> {
//                String string = json.getAsJsonPrimitive().getAsString();
//                if (Strings.isNullOrEmpty(string)) {
//                    return null;
//                }
//                return LocalTime.parse(string, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER));
//            })
//            .create();
//    PRETTY_GSON =new GsonBuilder().serializeNulls()
//    .registerTypeAdapter(LocalDateTime .class, (JsonSerializer<LocalDateTime>) (localDateTime,typeOfSrc,context)->
//
//    {
//        if (Objects.isNull(localDateTime)) {
//            return new JsonPrimitive("");
//        }
//        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER)));
//    })
//            .
//
//    registerTypeAdapter(LocalDateTime .class, (JsonDeserializer<LocalDateTime>) (json1,typeOfT,context)->
//
//    {
//        String string = json1.getAsJsonPrimitive().getAsString();
//        if (Strings.isNullOrEmpty(string)) {
//            return null;
//        }
//        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER));
//    })
//            .
//
//    registerTypeAdapter(LocalDate .class, (JsonSerializer<LocalDate>) (localDate,type,jsonSerializationContext)->
//
//    {
//        if (Objects.isNull(localDate)) {
//            return new JsonPrimitive("");
//        }
//        return new JsonPrimitive(localDate.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER)));
//    })
//            .
//
//    registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json,typeOfT,context)->
//
//    {
//        String string = json.getAsJsonPrimitive().getAsString();
//        if (Strings.isNullOrEmpty(string)) {
//            return null;
//        }
//        return LocalDate.parse(string, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER));
//    })
//            .
//
//    registerTypeAdapter(LocalTime .class, (JsonSerializer<LocalTime>) (localTime,type,jsonSerializationContext)->
//
//    {
//        if (Objects.isNull(localTime)) {
//            return new JsonPrimitive("");
//        }
//        return new JsonPrimitive(localTime.format(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER)));
//    })
//            .
//
//    registerTypeAdapter(LocalTime .class, (JsonDeserializer<LocalTime>) (json,typeOfT,context)->
//
//    {
//        String string = json.getAsJsonPrimitive().getAsString();
//        if (Strings.isNullOrEmpty(string)) {
//            return null;
//        }
//        return LocalTime.parse(string, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER));
//    })
//            .
//
//    setPrettyPrinting()
//                .
//
//    create();
//
//    @Bean
//    public GsonDecoder gsonDecoder() {
//        return new GsonDecoder(gson);
//    }
//
//    @Bean
//    public GsonEncoder gsonEncoder() {
//        return new GsonEncoder(gson);
//    }
}
