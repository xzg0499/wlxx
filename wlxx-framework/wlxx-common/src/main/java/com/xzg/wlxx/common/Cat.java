package com.xzg.wlxx.common;

import com.xzg.wlxx.ast.annotation.WlxxBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@WlxxBuilder
public class Cat extends Animal {
    private Integer sex;


}
