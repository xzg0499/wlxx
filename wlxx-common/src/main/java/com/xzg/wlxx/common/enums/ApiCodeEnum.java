package com.xzg.wlxx.common.enums;

import lombok.Getter;

/**
 * @author XiaoZG
 */
@Getter
public enum ApiCodeEnum {
    NULL(404, "null"),
    NO_AUTH(401, "认证失败"),
    
    ;


    private final Integer code;
    private final String msg;

    ApiCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
