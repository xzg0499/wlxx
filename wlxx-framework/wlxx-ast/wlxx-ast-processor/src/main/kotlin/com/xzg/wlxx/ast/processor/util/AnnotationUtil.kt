package com.xzg.wlxx.ast.processor.util

import com.xzg.wlxx.ast.annotation.designpattern.Observer
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