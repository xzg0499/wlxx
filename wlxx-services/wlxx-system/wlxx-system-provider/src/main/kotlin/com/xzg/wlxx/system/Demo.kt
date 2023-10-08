package com.xzg.wlxx.system

import kotlinx.coroutines.*

/**
 * @author XiaoZG
 */
class Demo {
}


fun main() = runBlocking<Unit> {
    val a = async {
        println("I'm computing part of the answer")
        6
    }
    val b = async {
        println("I'm computing another part of the answer")
        7
    }
    println("The answer is ${a.await() * b.await()}")
}