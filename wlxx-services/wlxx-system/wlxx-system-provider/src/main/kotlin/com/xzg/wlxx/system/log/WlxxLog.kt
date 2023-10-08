package com.xzg.wlxx.system.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author XiaoZG
 */

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class WlxxLog {
    companion object {
        val <reified T> T.log: Logger
            inline get() = LoggerFactory.getLogger(T::class.java)
    }
}