package com.xzg.wlxx.common.enums;

import lombok.Getter;

/**
 * @author XiaoZG
 */
@Getter
public enum ApiCode {
    NULL(404, "null"),
    NO_AUTH(401, "认证失败"),

    ;


    public final Integer code;
    public final String msg;

    ApiCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
