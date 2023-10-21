package com.xzg.wlxx.library.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Dog extends Animal {
    private String name;
}
