@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.lombok.util

import com.xzg.wlxx.lombok.annotation.designpattern.Observer
import javax.lang.model.type.MirroredTypeException
import javax.lang.model.type.TypeMirror


/**
 * Created by apple on 2019/1/17.
 */
fun Observer.getValue(): TypeMirror? {
    try {
        this.value
    } catch (mte: MirroredTypeException) {
        return mte.typeMirror
    }
    return null
}