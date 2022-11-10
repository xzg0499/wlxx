package com.xzg.wlxx.common.web.serializable;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
public class IPageDeserializer<T> extends StdDeserializer<IPage<T>> {

    public IPageDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public IPage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        String s = node.toString();
        ObjectMapper om = new ObjectMapper();

        Page<T> page = om.readValue(s, Page.class);
        return page;
    }
}
