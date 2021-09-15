package com.xzg.wlxx.framework.utils.serialization.json;

import java.util.Locale;

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
