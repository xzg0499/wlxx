package com.xzg.wlxx.common.utils.serialization.json;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/9
 */
public class JsonKeyUpStrategy implements JsonStrategy {
    @Override
    public String getName(String name) {
        return name.toUpperCase();
    }

    @Override
    public Boolean isNull() {
        return false;
    }
}
