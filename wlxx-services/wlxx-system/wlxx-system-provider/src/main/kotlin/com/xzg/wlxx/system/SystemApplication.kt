package com.xzg.wlxx.system

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author XiaoZG
 */
@SpringBootApplication
class SystemApplication

fun main(args: Array<String>) {
    runApplication<SystemApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}