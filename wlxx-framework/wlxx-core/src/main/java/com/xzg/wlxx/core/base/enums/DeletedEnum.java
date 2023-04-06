package com.xzg.wlxx.core.base.enums;

import lombok.Getter;

/**
 * 是否删除
 *
 * @author xzgan
 * @date 2023/4/6
 */
@Getter
public enum DeletedEnum {
    DELETED(1, "删除"),
    UNDELETED(0, "未删除"),
    ;


    private final Integer code;
    private final String desc;

    DeletedEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
