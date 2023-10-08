package com.xzg.wlxx.system.client.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexEnum {
    MAIL(0, "男"),
    FEMALE(1, "女"),
    NULL(null, null),
    ;

    @EnumValue
    private final Integer code;
    @JsonValue
    private final String desc;

    SexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
