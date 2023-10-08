package com.xzg.wlxx.apt

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * @author XiaoZG
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(
    AnnotationRetention.RUNTIME
)
@MustBeDocumented
@RequestMapping(method = [RequestMethod.POST])
annotation class AutoFeign(val name: String = "")
