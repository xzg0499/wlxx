package com.xzg.wlxx.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Cat extends Animal {
    private Integer sex;

}
