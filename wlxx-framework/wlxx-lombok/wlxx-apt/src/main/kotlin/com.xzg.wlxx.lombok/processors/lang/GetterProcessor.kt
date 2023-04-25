@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.lombok.processors.lang

import com.google.auto.service.AutoService
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import com.sun.source.tree.Tree
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.tree.JCTree
import com.sun.tools.javac.tree.JCTree.*
import com.sun.tools.javac.tree.TreeTranslator
import com.sun.tools.javac.util.List
import com.sun.tools.javac.util.ListBuffer
import com.sun.tools.javac.util.Name
import com.xzg.wlxx.lombok.annotation.lang.Getter
import com.xzg.wlxx.lombok.base.SingleAnnotationProcessor
import com.xzg.wlxx.lombok.util.appendIf
import com.xzg.wlxx.lombok.util.asGetter
import com.xzg.wlxx.lombok.util.contains
import javax.annotation.processing.Processor
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement

@Suppress("unused")
@AutoService(Processor::class)
internal class GetterProcessor : SingleAnnotationProcessor() {
    override val mAnnotation = Getter::class.java

    private var mFields: List<JCVariableDecl> = List.nil()

    override fun translate(curElement: TypeElement, curTree: JCTree) {
        curTree.accept(MyTreeTranslator(curElement.simpleName as Name))
    }

    override fun generateJavaFile(curElement: TypeElement, curTree: JCTree) {
        getJavaFile(curElement).writeTo(filer)
    }

    private fun getJavaFile(curElement: TypeElement): JavaFile {
        val packageName = rootTree?.packageName?.toString() ?: ""

        val curIGetter = TypeSpec.interfaceBuilder(
            "${
                curElement.qualifiedName.substring(packageName.length + 1).replace(".", "$$")
            }\$\$IGetter"
        )
            .addModifiers(Modifier.PUBLIC)
            .apply {
                mFields.forEach {
                    this.addMethod(
                        MethodSpec.methodBuilder(it.name.toString().asGetter())
                            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                            .returns(ClassName.get(it.sym.asType()))
                            .build()
                    )
                }
            }
            .build()

        return JavaFile.builder(packageName, curIGetter)
            .build()
    }

    inner class MyTreeTranslator(private val rootClazzName: Name) : TreeTranslator() {

        override fun visitClassDef(jcClassDecl: JCClassDecl) {
            if (jcClassDecl.name == rootClazzName) {
                mFields = List.nil()
                jcClassDecl.defs
                    .filter { it.kind == Tree.Kind.VARIABLE }
                    .map { it as JCVariableDecl }
                    .forEach {
                        mFields = mFields.append(it)

                        jcClassDecl.defs = jcClassDecl.defs
                            .appendIf(makeGetterMethodDecl(it)) {
                                !jcClassDecl.contains(it as JCMethodDecl)
                            }
                    }
            }
            super.visitClassDef(jcClassDecl)
        }

        /**
         *   public String getName() {
         *      return this.name;
         *   }
         */
        private fun makeGetterMethodDecl(jcVariableDecl: JCVariableDecl): JCMethodDecl {
            val body = ListBuffer<JCStatement>()
                .append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names._this), jcVariableDecl.getName())))
                .toList()
                .let { treeMaker.Block(0, it) }

            return treeMaker.MethodDef(
                treeMaker.Modifiers(Flags.PUBLIC.toLong()),
                names.fromString(jcVariableDecl.getName().toString().asGetter()),
                jcVariableDecl.vartype,
                List.nil(), List.nil(), List.nil(), body, null
            )
        }
    }
}
