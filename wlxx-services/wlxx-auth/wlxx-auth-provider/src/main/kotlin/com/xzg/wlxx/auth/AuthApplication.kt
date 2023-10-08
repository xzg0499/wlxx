package com.xzg.wlxx.auth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author XiaoZG
 */
@SpringBootApplication
object AuthApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(AuthApplication::class.java, *args)
    }
}
