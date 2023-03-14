package com.xzg.wlxx.web.config;

import org.springframework.context.annotation.Configuration;

/**
 * 接口参数序列化
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.web.config
 * @date 2022/11/11 10:58
 */
@Configuration
public class JsonHttpMessageConvertor {

    //@Bean
    //public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
    //    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    //    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //    SimpleModule module = new SimpleModule();
    //    module.addSerializer(Long.class, ToStringSerializer.instance);
    //    module.addSerializer(Long.TYPE, ToStringSerializer.instance);
    //    objectMapper.registerModule(module);
    //    return objectMapper;
    //}
}
