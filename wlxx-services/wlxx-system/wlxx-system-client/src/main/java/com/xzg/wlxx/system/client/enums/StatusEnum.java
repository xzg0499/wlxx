package com.xzg.wlxx.system.client.enums;

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
public enum StatusEnum implements IEnum<Integer> {
    NO(0,"否"),
    YES(2,"是"),
    ;

    @EnumValue
    private final Integer value;
    @JsonValue
    private String desc;

    StatusEnum(Integer code, String sex){
        this.value = code;
        this.desc = sex;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
