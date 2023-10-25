package com.xzg.wlxx.common;

import com.xzg.wlxx.ast.annotation.AutoFeign;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoFeign
public class Dog extends Animal {
    private Integer sex;
}
