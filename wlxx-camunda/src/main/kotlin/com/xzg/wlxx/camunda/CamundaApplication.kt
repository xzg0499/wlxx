package com.xzg.wlxx.camunda

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableProcessApplication
class CamundaApplication {

}

fun main(args: Array<String>) {
    runApplication<CamundaApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}