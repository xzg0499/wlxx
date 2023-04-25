package com.xzg.wlxx.lombok

/**
 * @author xzgan
 * @date 2023/3/30
 */
fun main(args: Array<String>) {
    var plugin = LombokPlugin();
    plugin.print();
}

class LombokPlugin {


    fun print() {
        println("hello lombok plugin")
    }
}
