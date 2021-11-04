package com.xzg.wlxx.common.utils.serialization.json;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/20
 */
public class JsonKeyLowerStrategy implements JsonStrategy{
    @Override
    public String getName(String name) {
        return name.toLowerCase();
    }

    @Override
    public Boolean isNull() {
        return true;
    }
}
