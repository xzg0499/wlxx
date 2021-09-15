package com.xzg.wlxx.framework.utils.serialization.json;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/19
 */
public class JsonKeyCamelCaseStrategy implements JsonStrategy{
    @Override
    public String getName(String name) {
        //TODO 待实现
        return name;
    }

    @Override
    public Boolean isNull() {
        return false;
    }
}
