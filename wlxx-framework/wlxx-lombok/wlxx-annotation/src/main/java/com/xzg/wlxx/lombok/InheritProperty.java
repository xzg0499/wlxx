package com.xzg.wlxx.lombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xzgan
 * @date 2023/4/21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface InheritProperty {
}
