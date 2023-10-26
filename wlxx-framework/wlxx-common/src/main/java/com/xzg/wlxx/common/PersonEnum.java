package com.xzg.wlxx.common;

/**
 * @author XiaoZG
 */
//@AutoFeign(name = "HelloWorld")
public enum PersonEnum {
    NAME(1, "1");

    private int status;
    private String description;

    PersonEnum(int status, String description) {
        this.status = status;
        this.description = description;
    }
}
