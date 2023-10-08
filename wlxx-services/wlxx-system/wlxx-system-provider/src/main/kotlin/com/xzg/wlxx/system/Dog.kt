package com.xzg.wlxx.system

import lombok.NoArgsConstructor

/**
 * @author XiaoZG
 */
@NoArgsConstructor
data class Dog(var name: String)

fun main() {
    val d = Dog("??")
    println("$d")
}
