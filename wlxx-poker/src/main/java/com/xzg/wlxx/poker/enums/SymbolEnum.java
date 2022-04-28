package com.xzg.wlxx.poker.enums;

/**
 * @author xzgang0499
 * @date 2022-04-22
 * @since jdk1.8
 */
public enum SymbolEnum {
    M(1,"M")
    ;


    private Integer code;
    private String value;

    SymbolEnum(Integer code,String value){
        this.code = code;
        this.value = value;
    }
}
