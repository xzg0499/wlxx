package com.xzg.wlxx.common;

/**
 * @author XiaoZG
 */
//@AutoFeign(name = "Hello")
public enum Demo {

    D(1, "2"),
    ;

    private final Integer code;
    private final String desc;

    Demo(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
