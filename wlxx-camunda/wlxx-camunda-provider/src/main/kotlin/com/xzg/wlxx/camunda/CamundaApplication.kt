package com.xzg.wlxx.camunda

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object CamundaApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(CamundaApplication::class.java)
    }
}
