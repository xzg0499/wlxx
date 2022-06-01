package com.xzg.wlxx.system.client.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xzgang0499
 * @date 2022-04-22
 * @since jdk1.8
 */
public enum SexEnum {
    SEX_MAX(1,"男"),
    SEX_FALMAN(2,"女"),
    ;

    @EnumValue
    private Integer code;
    @JsonValue
    private String sex;

    SexEnum(Integer code,String sex){
        this.code = code;
        this.sex = sex;
    }
}
