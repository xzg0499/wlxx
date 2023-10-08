package com.xzg.wlxx.system

import lombok.NoArgsConstructor
import kotlin.reflect.KProperty

/**
 * @author XiaoZG
 */
@NoArgsConstructor
data class Animal(var name: String)

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun main() {
    val e = Example()
    println(e.p)
//    val a = Animal::class.java.getDeclaredConstructor().newInstance();
//    println("$a")
}

