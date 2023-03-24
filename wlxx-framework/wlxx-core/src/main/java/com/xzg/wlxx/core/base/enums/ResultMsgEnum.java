package com.xzg.wlxx.core.base.enums;

import lombok.Getter;

/**
 * API响应枚举
 *
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
@Getter
public enum ResultMsgEnum {
    SUCCESS(20000, "操作成功"),
    FAILURE(40000, "操作失败"),
    NULL(40004, "空指针异常"),
    NOT_FOUND(40004, "地址找不到"),

    DB_DUPLICATE_KEY(50000, "数据库主键重复");

    private final Integer code;
    private final String msg;

    ResultMsgEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
