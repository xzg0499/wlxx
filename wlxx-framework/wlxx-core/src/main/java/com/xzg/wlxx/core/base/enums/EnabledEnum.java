package com.xzg.wlxx.core.base.enums;

import lombok.Getter;

/**
 * 是否启用
 *
 * @author xzgan
 * @date 2023/4/6
 */
@Getter
public enum EnabledEnum {
    ENABLED(1, "启用"),
    DISABLED(0, "禁用"),
    ;


    private final Integer code;
    private final String desc;

    EnabledEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
