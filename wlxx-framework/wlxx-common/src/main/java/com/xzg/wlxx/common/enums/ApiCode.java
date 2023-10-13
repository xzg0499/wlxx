package com.xzg.wlxx.common.enums;

import cn.hutool.core.util.EnumUtil;
import lombok.Getter;

/**
 * @author XiaoZG
 */
@Getter
public enum ApiCode {
    NULL(404, "null"),
    NO_AUTH(401, "认证失败"),

    ;


    private final Integer code;
    private final String msg;

    ApiCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiCode findByCode(Integer code) {
        return EnumUtil.getBy(ApiCode::getCode, code, ApiCode.NULL);
    }
}
