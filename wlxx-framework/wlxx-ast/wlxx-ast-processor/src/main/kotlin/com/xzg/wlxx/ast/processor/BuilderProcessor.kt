@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.ast.processor

import com.google.auto.service.AutoService
import com.sun.tools.javac.api.JavacTrees
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.code.TypeTag
import com.sun.tools.javac.processing.JavacProcessingEnvironment
import com.sun.tools.javac.tree.JCTree
import com.sun.tools.javac.tree.TreeMaker
import com.sun.tools.javac.tree.TreeTranslator
import com.sun.tools.javac.util.List
import com.sun.tools.javac.util.Names
import com.xzg.wlxx.ast.annotation.WlxxBuilder
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.tools.Diagnostic


/**
 * @author XiaoZG
 */
@SupportedSourceVersion(value = SourceVersion.RELEASE_17)
@AutoService(Processor::class)
@Suppress("unused")
class BuilderProcessor : AbstractProcessor() {

    private var messager: Messager? = null
    var trees: JavacTrees? = null
    var treeMaker: TreeMaker? = null
    var names: Names? = null;

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        messager = processingEnv.messager
        trees = JavacTrees.instance(processingEnv)
        val context = (processingEnv as JavacProcessingEnvironment).context
        treeMaker = TreeMaker.instance(context)
        names = Names.instance(context)
    }

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        messager!!.printMessage(Diagnostic.Kind.NOTE, "roundEnv -> $roundEnv")
        // 获取被@EnumInnerConstant注解标记的所有元素(可能是类、变量、方法等等)
        val elementSet = roundEnv.getElementsAnnotatedWith(
            WlxxBuilder::class.java
        )
        elementSet.forEach { element: Element ->
            val paramsNameValueMap: MutableMap<String, Any?> = ConcurrentHashMap(8)
            val paramsNameTypeMap: MutableMap<String, JCTree.JCExpression> = ConcurrentHashMap(8)
            val paramIndexHelper: MutableMap<String, AtomicInteger> = ConcurrentHashMap(4)

            val innerClassName = "Builder"
            val jcTree = trees!!.getTree(element)
            val className = "";

            jcTree.accept(object : TreeTranslator() {
                override fun visitClassDef(jcClassDecl: JCTree.JCClassDecl) {
                    super.visitClassDef(jcClassDecl)

                    val innerClass = generateInnerClass(innerClassName, paramsNameValueMap, paramsNameTypeMap)
                    jcClassDecl.defs = jcClassDecl.defs.append(innerClass)
                }

                override fun visitVarDef(jcVariableDecl: JCTree.JCVariableDecl) {

                    val name = jcVariableDecl.getName()
                    val paramName = name.toString()
                    val typetag = jcVariableDecl.type

                    val paramType: JCTree.JCExpression = treeMaker!!.TypeIdent(TypeTag.INT)


                    var atomicInteger = paramIndexHelper[paramName]
                    if (atomicInteger == null) {
                        atomicInteger = AtomicInteger(0)
                        paramIndexHelper[paramName] = atomicInteger
                    }
                    val key = paramName
                    paramsNameTypeMap[key] = paramType
                    paramsNameValueMap[key] = 1

                    super.visitVarDef(jcVariableDecl)
                }
            })
        }
        return false;
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(WlxxBuilder::class.java.name)
    }

    private fun generateInnerClass(
        innerClassName: String,
        paramsInfoMap: Map<String, Any?>,
        paramsNameTypeMap: Map<String, JCTree.JCExpression>
    ): JCTree.JCClassDecl {
        val jcClassDecl1 = treeMaker!!.ClassDef(
            treeMaker!!.Modifiers((Flags.PUBLIC + Flags.STATIC).toLong()),
            names!!.fromString(innerClassName),
            List.nil(),
            null,
            List.nil(),
            List.nil()
        )
        val collection = generateAllParameters(paramsInfoMap, paramsNameTypeMap)
        collection.forEach(Consumer { x: JCTree.JCVariableDecl? -> jcClassDecl1.defs = jcClassDecl1.defs.append(x) })
        return jcClassDecl1
    }

    private fun generateAllParameters(
        paramNameValueMap: Map<String, Any?>?,
        paramsNameTypeMap: Map<String, JCTree.JCExpression>
    ): List<JCTree.JCVariableDecl> {
        var jcVariableDeclList = List.nil<JCTree.JCVariableDecl>()
        var statement: JCTree.JCVariableDecl
        if (paramNameValueMap != null && paramNameValueMap.size != 0) {
            for ((key, value) in paramNameValueMap) {
                // 定义变量
                statement = treeMaker!!.VarDef( // 访问修饰符
                    treeMaker!!.Modifiers((Flags.PUBLIC).toLong()),  // 参数名
                    names!!.fromString(key),  // 参数类型
                    paramsNameTypeMap[key],  // 参数值
                    treeMaker!!.Literal(value)
                )
                jcVariableDeclList = jcVariableDeclList.append(statement)
            }
        }
        return jcVariableDeclList
    }

    private fun isPrimitive(typeTag: TypeTag?): Boolean {
        if (typeTag == null) {
            return false
        }
        val typeKind: TypeKind?
        typeKind = try {
            typeTag.primitiveTypeKind
        } catch (e: Throwable) {
            return false
        }
        return typeKind?.isPrimitive ?: false
    }

    private fun generateJcExpression(fullNameOfTheClass: String): JCTree.JCExpression {
        val fullNameOfTheClassArray =
            fullNameOfTheClass.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var expr: JCTree.JCExpression = treeMaker!!.Ident(names!!.fromString(fullNameOfTheClassArray[0]))
        for (i in 1 until fullNameOfTheClassArray.size) {
            expr = treeMaker!!.Select(expr, names!!.fromString(fullNameOfTheClassArray[i]))
        }
        return expr
    }
}