package com.xzg.wlxx.lombok

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author xzgan
 * @date 2023/3/30
 */
fun main(args: Array<String>) {
    var plugin = DemoKotlin();
    plugin.print();
}

class LombokPlugin : Plugin<Project> {
    

    fun print() {
        println("hello lombok plugin")
    }
}
