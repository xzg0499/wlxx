package com.xzg.wlxx.common;

import com.xzg.wlxx.ast.annotation.AutoFeign;

/**
 * @author XiaoZG
 */
@AutoFeign(name = "HelloWorld")
public enum PersonEnum {
    NAME(1, "1");

    private int status;
    private String description;

    PersonEnum(int status, String description) {
        this.status = status;
        this.description = description;
    }
}
