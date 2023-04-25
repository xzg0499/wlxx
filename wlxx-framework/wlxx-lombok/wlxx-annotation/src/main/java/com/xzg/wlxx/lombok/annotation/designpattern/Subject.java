package com.xzg.wlxx.lombok.annotation.designpattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Subject {
    /**
     * class of observer
     */
    Observer[] value();
}
