@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.lombok.processors.util

import com.google.auto.service.AutoService
import com.sun.tools.javac.tree.JCTree
import com.sun.tools.javac.tree.JCTree.JCClassDecl
import com.sun.tools.javac.tree.TreeTranslator
import com.sun.tools.javac.util.Name
import com.xzg.wlxx.lombok.base.AllFileProcessor
import com.xzg.wlxx.lombok.util.removeAbstractIfNeed
import javax.annotation.processing.Processor
import javax.lang.model.element.TypeElement

@Suppress("unused")
@AutoService(Processor::class)
internal class CheckClassDefProcessor : AllFileProcessor() {

    override fun translate(curElement: TypeElement, curTree: JCTree) {
        curTree.accept(MyTreeTranslator(curElement.simpleName as Name))
    }

    inner class MyTreeTranslator(private val rootClazzName: Name) : TreeTranslator() {

        override fun visitClassDef(jcClassDecl: JCClassDecl) {
//            if (jcClassDecl.name == rootClazzName) {
            // 去掉 abstract
            jcClassDecl.removeAbstractIfNeed()
//            }
            super.visitClassDef(jcClassDecl)
        }
    }
}
