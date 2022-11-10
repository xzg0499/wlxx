package com.xzg.wlxx.core.enums;

import lombok.Getter;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
@Getter
public enum ResEnum {
    SUCCESS(20000, "操作成功"),
    FAILURE(40000, "操作失败"),
    NULL(40004, "空指针异常"),
    ;

    private Integer code;
    private String msg;

    private ResEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
