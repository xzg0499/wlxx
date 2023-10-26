@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.ast.processor.base

import com.sun.tools.javac.tree.JCTree
import com.xzg.wlxx.ast.processor.util.logd
import java.io.IOException
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

abstract class AllFileProcessor : BaseProcessor() {
    private var mIsFirstRound = true

    protected var rootTree: JCTree.JCCompilationUnit? = null

    final override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf("*")
    }

    final override fun process(set: Set<TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        if (!mIsFirstRound) {
            return false
        }
        mIsFirstRound = false

        logd("process begin !!! set = $set")

        roundEnvironment.getRootElements()
            .filter { it is TypeElement }
            .map { it as TypeElement }
            .forEach {
                val treePath = trees.getPath(it)
                val cu = treePath.compilationUnit as JCTree.JCCompilationUnit
                rootTree = cu
                logd("process find class = $it, jcTree = ${cu.javaClass.simpleName}")
                translate(it, trees.getTree(it) as JCTree)

                try {
                    generateJavaFile(it, trees.getTree(it) as JCTree)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        logd("process end !!!")
        return true
    }


    abstract fun translate(curElement: TypeElement, curTree: JCTree)

    @Throws(IOException::class)
    open fun generateJavaFile(curElement: TypeElement, curTree: JCTree) {
    }
}