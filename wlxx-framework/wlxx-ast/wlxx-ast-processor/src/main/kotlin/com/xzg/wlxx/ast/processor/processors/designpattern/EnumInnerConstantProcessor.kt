@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.xzg.wlxx.ast.processor.processors.designpattern

import com.google.auto.service.AutoService
import com.sun.tools.javac.api.JavacTrees
import com.sun.tools.javac.code.Flags
import com.sun.tools.javac.code.TypeTag
import com.sun.tools.javac.processing.JavacProcessingEnvironment
import com.sun.tools.javac.tree.JCTree.*
import com.sun.tools.javac.tree.TreeMaker
import com.sun.tools.javac.tree.TreeTranslator
import com.sun.tools.javac.util.List
import com.sun.tools.javac.util.Names
import com.xzg.wlxx.ast.annotation.AutoFeign
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import java.util.regex.Pattern
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
class EnumInnerConstantProcessor : AbstractProcessor() {
    /**
     * 消息记录器
     */
    private var messager: Messager? = null

    /**
     * 可将Element转换为JCTree的工具。(注: 简单的讲，处理AST, 就是处理一个又一个CTree)
     */
    private var trees: JavacTrees? = null

    /**
     * JCTree制作器
     */
    private var treeMaker: TreeMaker? = null

    /**
     * 名字处理器
     */
    private var names: Names? = null

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        messager = processingEnv.messager
        trees = JavacTrees.instance(processingEnv)
        val context = (processingEnv as JavacProcessingEnvironment).context
        treeMaker = TreeMaker.instance(context)
        names = Names.instance(context)
    }

    override fun process(annotations: Set<TypeElement?>, roundEnv: RoundEnvironment): Boolean {
        messager!!.printMessage(Diagnostic.Kind.NOTE, "roundEnv -> $roundEnv")
        // 获取被@EnumInnerConstant注解标记的所有元素(可能是类、变量、方法等等)
        val elementSet = roundEnv.getElementsAnnotatedWith(
            AutoFeign::class.java
        )
        elementSet.forEach { element: Element? ->
            /*
             * 存储参数名与参数值的map、存储参数名与参数类型的map、一个辅助计数的map
             * <p>
             * 注: 照理来说，这里是单线程的。但考虑到本人对AST的处理机制也不是很熟，为
             *     保证万无一失，这里直接用线程安全的类吧。
             */
            val paramsNameValueMap: MutableMap<String, Any?> = ConcurrentHashMap(8)
            val paramsNameTypeMap: MutableMap<String, JCExpression> = ConcurrentHashMap(8)
            val paramIndexHelper: MutableMap<String, AtomicInteger> = ConcurrentHashMap(4)

            // 获取到注解信息
            val annotation = element!!.getAnnotation(AutoFeign::class.java)
            val originInnerClassName = annotation.name
            // 内部类类名校验
            val innerClassName = checkInnerClassName(originInnerClassName)
            // 将Element转换为JCTree
            val jcTree = trees!!.getTree(element)
            val className = (jcTree as JCClassDecl).sym.type.toString()
            val enumFlag = "enum"
            if (!enumFlag.equals(jcTree.getKind().name, ignoreCase = true)) {
                // 为保证错误信息能在各种情况下都能被看到, 这里用多种方式记录错误信息
                val errorMessage = "@EnumInnerConstant only support enum-class, [$className] is not supported"
                System.err.println(errorMessage)
                messager!!.printMessage(Diagnostic.Kind.ERROR, errorMessage)
                throw RuntimeException(errorMessage)
            }
            /*
             * 通过JCTree.accept(JCTree.Visitor)访问JCTree对象的内部信息。
             *
             * JCTree.Visitor有很多方法，我们可以通过重写对应的方法,(从该方法的形参中)来获取到我们想要的信息:
             * 如: 重写visitClassDef方法， 获取到类的信息;
             *     重写visitMethodDef方法， 获取到方法的信息;
             *     重写visitVarDef方法， 获取到变量的信息;
             *     重写visitLabelled方法， 获取到常量的信息;
             *     重写visitBlock方法， 获取到方法体的信息;
             *     重写visitImport方法， 获取到导包信息;
             *     重写visitForeachLoop方法， 获取到for循环的信息;
             *     ......
             */jcTree.accept(object : TreeTranslator() {
            override fun visitClassDef(jcClassDecl: JCClassDecl) {
                // 不要放在 jcClassDecl.defs = jcClassDecl.defs.append(a);之后，否者会递归
                super.visitClassDef(jcClassDecl)
                // 生成内部类， 并将内部类写进去
                val innerClass = generateInnerClass(innerClassName, paramsNameValueMap, paramsNameTypeMap)
                jcClassDecl.defs = jcClassDecl.defs.append(innerClass)
            }

            override fun visitVarDef(jcVariableDecl: JCVariableDecl) {
                val isEnumConstant = className == jcVariableDecl.vartype.type.toString()
                if (!isEnumConstant) {
                    super.visitVarDef(jcVariableDecl)
                    return
                }
                val name = jcVariableDecl.getName()
                val paramName = name.toString()
                /*
                     * 枚举项本身也属于变量, 每个枚举项里面，可能还有变量。 这里继
                     * 续JCTree.accept(JCTree.Visitor)进入，访问这个枚举项的内部信息。
                     */jcVariableDecl.accept(object : TreeTranslator() {
                    override fun visitLiteral(jcLiteral: JCLiteral) {
                        val paramValue = jcLiteral.getValue() ?: return
                        val typetag = jcLiteral.typetag
                        val paramType: JCExpression
                        paramType = if (isPrimitive(typetag)) {
                            // 如果是基本类型，那么可以直接生成
                            treeMaker!!.TypeIdent(typetag)
                        } else if (paramValue is String) {
                            // 如果不是基本类型，那么需要拼接生成
                            generateJcExpression("java.lang.String")
                        } else {
                            return
                        }
                        var atomicInteger = paramIndexHelper[paramName]
                        if (atomicInteger == null) {
                            atomicInteger = AtomicInteger(0)
                            paramIndexHelper[paramName] = atomicInteger
                        }
                        val paramIndex = atomicInteger.getAndIncrement()
                        val key = paramName + "_" + paramIndex
                        paramsNameTypeMap[key] = paramType
                        paramsNameValueMap[key] = paramValue
                        super.visitLiteral(jcLiteral)
                    }
                })
                super.visitVarDef(jcVariableDecl)
            }
        })
        }
        return false
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(AutoFeign::class.java.name)
    }

    /**
     * 内部类类名 合法性校验
     *
     * @param innerClassName 内部类类名
     * @return 校验后的内部类类名
     * @date 2020/5/17 13:45:27
     */
    private fun checkInnerClassName(innerClassName: String): String {
        var innerClassName: String? = innerClassName
        if (innerClassName == null || innerClassName.trim { it <= ' ' }.length == 0) {
            // 为保证错误信息能在各种情况下都能被看到, 这里用多种方式记录错误信息
            val errorMessage = "@EnumInnerConstant. inner-class-name cannot be empty"
            System.err.println(errorMessage)
            messager!!.printMessage(Diagnostic.Kind.ERROR, errorMessage)
            throw RuntimeException(errorMessage)
        }
        innerClassName = innerClassName.trim { it <= ' ' }
        if (!INNER_CLASS_NAME_PATTERN.matcher(innerClassName).matches()) {
            // 为保证错误信息能在各种情况下都能被看到, 这里用多种方式记录错误信息
            val errorMessage = "@EnumInnerConstant. inner-class-name must match regex " + INNER_CLASS_NAME_REGEX
            System.err.println(errorMessage)
            messager!!.printMessage(Diagnostic.Kind.ERROR, errorMessage)
            throw RuntimeException(errorMessage)
        }
        return innerClassName
    }

    /**
     * 判断typeTag是否属于基本类型
     *
     * @param typeTag typeTag
     * @return 是否属于基本类型
     * @date 2020/5/17 13:10:54
     */
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

    /**
     * 生成内部类
     *
     * @return 生成出来的内部类
     * @date 2020/5/16 15:43:56
     */
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
        return jcClassDecl1
    }

    /**
     * 生成参数
     *
     * @param paramNameValueMap 参数名-参数值map
     * @param paramsNameTypeMap 参数名-参数类型map
     * @return 参数JCTree集合
     * @date 2020/5/16 15:44:47
     */
    private fun generateAllParameters(
        paramNameValueMap: Map<String, Any?>?,
        paramsNameTypeMap: Map<String, JCExpression>
    ): List<JCVariableDecl> {
        var jcVariableDeclList = List.nil<JCVariableDecl>()
        var statement: JCVariableDecl
        if (paramNameValueMap != null && paramNameValueMap.size != 0) {
            for ((key, value) in paramNameValueMap) {
                // 定义变量
                statement = treeMaker!!.VarDef( // 访问修饰符
                    treeMaker!!.Modifiers((Flags.PUBLIC + Flags.STATIC + Flags.FINAL).toLong()),  // 参数名
                    names!!.fromString(key),  // 参数类型
                    paramsNameTypeMap[key],  // 参数值
                    treeMaker!!.Literal(value)
                )
                jcVariableDeclList = jcVariableDeclList.append(statement)
            }
        }
        return jcVariableDeclList
    }

    /**
     * 根据全类名获取JCTree.JCExpression
     *
     *
     * 如: 类变量 public static final String ABC = "abc";中, String就需要
     * 调用此方法generateJCExpression("java.lang.String")进行获取。
     * 追注: 其余的复杂类型，也可以通过这种方式进行获取。
     * 追注: 对于基本数据类型，可以直接通过类TreeMaker.TypeIdent获得，
     * 如: treeMaker.TypeIdent(TypeTag.INT)可获得int的JCTree.JCExpression
     *
     * @param fullNameOfTheClass 全类名
     * @return 全类名对应的JCTree.JCExpression
     * @date 2020/5/16 15:47:32
     */
    private fun generateJcExpression(fullNameOfTheClass: String): JCExpression {
        val fullNameOfTheClassArray =
            fullNameOfTheClass.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var expr: JCExpression = treeMaker!!.Ident(names!!.fromString(fullNameOfTheClassArray[0]))
        for (i in 1 until fullNameOfTheClassArray.size) {
            expr = treeMaker!!.Select(expr, names!!.fromString(fullNameOfTheClassArray[i]))
        }
        return expr
    }

    companion object {
        /**
         * 内部类类名校验
         */
        private const val INNER_CLASS_NAME_REGEX = "[A-Z][A-Za-z0-9]+"
        private val INNER_CLASS_NAME_PATTERN = Pattern.compile(INNER_CLASS_NAME_REGEX)
    }
}
