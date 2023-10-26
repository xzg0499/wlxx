package com.xzg.wlxx.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Dog extends Animal {
    private Integer sex;

    public static void main(String[] args) {

    }
}
