package com.xzg.wlxx.user.client.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author xzgang0499
 * @date 2022-04-22
 * @since jdk1.8
 */

@Getter
public enum SexEnum implements IEnum<Integer> {
    SEX_MALE(1,"男"),
    SEX_FEMALE(2,"女"),
    ;

    @EnumValue
    private final Integer value;
    @JsonValue
    private String desc;

    SexEnum(Integer code, String sex){
        this.value = code;
        this.desc = sex;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
