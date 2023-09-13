package com.xzg.wlxx.system.util

import java.lang.Thread.sleep

fun loop() {
    for (i in 0..100) {
        Thread() {
            sleep((10..100).random().toLong())
            println("thread : ${Thread.currentThread().name} num: ${i}")
        }.start()
    }
}
