package com.xzg.wlxx.web.serializable;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
//public class IPageDeserializer<T> extends StdDeserializer<IPage<T>> {
//
//    public IPageDeserializer(Class<?> vc) {
//        super(vc);
//    }
//
//    @Override
//    public IPage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
//        JsonNode node = p.getCodec().readTree(p);
//        String s = node.toString();
//        ObjectMapper om = new ObjectMapper();
//
//        Page<T> page = om.readValue(s, Page.class);
//        return page;
//    }
//}
