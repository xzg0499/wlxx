package com.xzg.wlxx.ast.annotation;

import java.lang.annotation.*;

/**
 * @author XiaoZG
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoFeign {

    String name() default "";
}
