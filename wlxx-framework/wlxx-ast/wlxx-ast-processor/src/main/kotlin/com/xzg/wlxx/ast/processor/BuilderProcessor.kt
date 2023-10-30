@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.ast.processor

import com.google.auto.service.AutoService
import com.sun.tools.javac.api.JavacTrees
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.code.TypeTag
import com.sun.tools.javac.processing.JavacProcessingEnvironment
import com.sun.tools.javac.tree.JCTree
import com.sun.tools.javac.tree.JCTree.*
import com.sun.tools.javac.tree.TreeMaker
import com.sun.tools.javac.tree.TreeTranslator
import com.sun.tools.javac.util.List
import com.sun.tools.javac.util.Name
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
            val paramsNameTypeMap: MutableMap<String, JCExpression> = ConcurrentHashMap(8)
            val paramIndexHelper: MutableMap<String, AtomicInteger> = ConcurrentHashMap(4)

            val innerClassName = "CatBuilder"
            val jcTree = trees!!.getTree(element)
            val className = (jcTree as JCClassDecl).sym.type.toString();

            jcTree.accept(object : TreeTranslator() {
                override fun visitClassDef(jcClassDecl: JCClassDecl) {
                    super.visitClassDef(jcClassDecl)

                    val innerClass = generateInnerClass(innerClassName, paramsNameValueMap, paramsNameTypeMap)
                    jcClassDecl.defs = jcClassDecl.defs.append(innerClass)
                }

                override fun visitVarDef(jcVariableDecl: JCVariableDecl) {
                    val name = jcVariableDecl.getName()
                    val paramName = name.toString()
                    val typetag = jcVariableDecl.type


                    val paramType: JCExpression = treeMaker!!.TypeIdent(TypeTag.INT)


                    var atomicInteger = paramIndexHelper[paramName]
                    if (atomicInteger == null) {
                        atomicInteger = AtomicInteger(0)
                        paramIndexHelper[paramName] = atomicInteger
                    }
                    val key = paramName
                    paramsNameTypeMap[key] = paramType
                    paramsNameValueMap[key] = 1

                    jcVariableDecl.accept(object : TreeTranslator() {
                        override fun visitVarDef(tree: JCVariableDecl?) {
                            messager!!.printMessage(Diagnostic.Kind.NOTE, "param -> ${tree!!.name}")

                            super.visitVarDef(tree)
                        }
                    })

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
        paramsNameTypeMap: Map<String, JCExpression>
    ): JCClassDecl {
        val jcClassDecl1 = treeMaker!!.ClassDef(
            treeMaker!!.Modifiers((Flags.PUBLIC + Flags.STATIC).toLong()),
            names!!.fromString(innerClassName),
            List.nil(),
            null,
            List.nil(),
            List.nil()
        )
        val collection = generateAllParameters(paramsInfoMap, paramsNameTypeMap)
        collection.forEach(Consumer { x: JCVariableDecl? -> jcClassDecl1.defs = jcClassDecl1.defs.append(x) })
        generateEqualMethod(jcClassDecl1);
//        val methods = generateAllMethod(paramsInfoMap, paramsNameTypeMap)
//        methods.forEach(Consumer { x: JCMethodDecl? -> jcClassDecl1.defs = jcClassDecl1.defs.append(x) })
        return jcClassDecl1
    }

    private fun generateAllParameters(
        paramNameValueMap: Map<String, Any?>?,
        paramsNameTypeMap: Map<String, JCExpression>
    ): List<JCVariableDecl> {
        var jcVariableDeclList = List.nil<JCVariableDecl>()
        var statement: JCVariableDecl
        if (!paramNameValueMap.isNullOrEmpty()) {
            for ((key, value) in paramNameValueMap) {
                // 定义变量
                statement = treeMaker!!.VarDef( // 访问修饰符
                    treeMaker!!.Modifiers((Flags.PRIVATE).toLong()),  // 参数名
                    names!!.fromString(key),  // 参数类型
                    paramsNameTypeMap[key],  // 参数值
                    treeMaker!!.Literal(value)
                )
                jcVariableDeclList = jcVariableDeclList.append(statement)
            }
        }
        return jcVariableDeclList
    }

    private fun generateAllMethod(
        paramNameValueMap: Map<String, Any?>?,
        paramsNameTypeMap: Map<String, JCExpression>
    ): List<JCMethodDecl> {
        var jcVariableDeclList = List.nil<JCMethodDecl>()
        var typeParams = List.nil<JCTree.JCTypeParameter>();
        var statementList = List.nil<JCVariableDecl>();
        var statement: JCVariableDecl
        var method: JCMethodDecl
        if (!paramNameValueMap.isNullOrEmpty()) {
            for ((key, value) in paramNameValueMap) {
                // 定义变量
                statement = treeMaker!!.VarDef( // 访问修饰符
                    treeMaker!!.Modifiers(Flags.FINAL.toLong()),  // 参数名
                    names!!.fromString(key),  // 参数类型
                    paramsNameTypeMap[key],  // 参数值
                    treeMaker!!.Literal(value)
                )

                method = treeMaker!!.MethodDef(
                    treeMaker!!.Modifiers(Flags.PUBLIC.toLong()),
                    names!!.fromString(key),
                    paramsNameTypeMap[key],
                    List.nil<JCTypeParameter>(),
                    List.of<JCVariableDecl>(
                        statement
                    ),
                    List.nil<JCExpression>(),
                    treeMaker!!.Block(
                        0,
                        List.of<JCStatement>(
                            statement
                        )
                    ),
                    null
                )

                jcVariableDeclList = jcVariableDeclList.append(method)
            }
        }
        return jcVariableDeclList
    }

    fun generateEqualMethod(classDecl: JCClassDecl): JCMethodDecl {
        val publicModifier = treeMaker!!.Modifiers(Flags.PUBLIC.toLong())
        var returnType: JCExpression? = treeMaker!!.Ident(names!!.fromString("java"))
        returnType = treeMaker!!.Select(returnType, names!!.fromString("lang"))
        returnType = treeMaker!!.Select(returnType, names!!.fromString("String"))
        val method: Name = names!!.fromString("sex")
        var ObjectExpr: JCExpression? = treeMaker!!.Ident(names!!.fromString("java"))
        ObjectExpr = treeMaker!!.Select(ObjectExpr, names!!.fromString("lang"))
        ObjectExpr = treeMaker!!.Select(ObjectExpr, names!!.fromString("Object"))
        val param = treeMaker!!.VarDef(
            treeMaker!!.Modifiers(Flags.PARAMETER),
            names!!.fromString("o"),
            ObjectExpr,
            null
        )
        param.pos = classDecl.pos
        val params = List.of(param)
        var statement = List.nil<JCStatement?>()
        val aNull: JCStatement = treeMaker!!.Return(treeMaker!!.Literal(TypeTag.BOT, this))
        statement = statement.append(aNull)
        val block = treeMaker!!.Block(0, statement)
        val methodDecl =
            treeMaker!!.MethodDef(
                publicModifier,
                method,
                returnType,
                List.nil(),
                params,
                List.nil(),
                block,
                null
            )
        println(methodDecl)
        classDecl.defs = classDecl.defs.append(methodDecl)
        return methodDecl
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

    private fun generateJcExpression(fullNameOfTheClass: String): JCExpression {
        val fullNameOfTheClassArray =
            fullNameOfTheClass.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var expr: JCExpression = treeMaker!!.Ident(names!!.fromString(fullNameOfTheClassArray[0]))
        for (i in 1 until fullNameOfTheClassArray.size) {
            expr = treeMaker!!.Select(expr, names!!.fromString(fullNameOfTheClassArray[i]))
        }
        return expr
    }
}