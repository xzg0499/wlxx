package com.xzg.wlxx.common.core.enums;

import lombok.Getter;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
@Getter
public enum ResponseEnum {
    SUCCESS(20000,"操作成功"),
    FAILURE(40000,"操作失败"),
    NULL(40004,"空对象"),
    ;

    private Integer code;
    private String msg;
    private ResponseEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
