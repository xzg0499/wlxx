package com.xzg.wlxx.framework.utils.serialization.json;

import com.xzg.wlxx.framework.utils.serialization.Strategy;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/9
 */
public interface JsonStrategy extends Strategy {
    public String getName(String name);

    //TODO null值在输出中怎么处理？
    public Boolean isNull();
}
