package com.xzg.wlxx.apt

import com.google.auto.service.AutoService
import com.squareup.javapoet.*
import java.io.IOException
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.*
import javax.lang.model.type.TypeMirror
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

/**
 * @author XiaoZG
 */
@SupportedAnnotationTypes(
    "com.xzg.wlxx.apt.AutoFeign" // 指定我们这个注解处理器能够处理的注解，写我们想要处理的注解
)
@SupportedSourceVersion(value = SourceVersion.RELEASE_17)
@AutoService(Processor::class)
class AutoGeneratorProcessor : AbstractProcessor() {
    private var filer: Filer? = null
    private var elementUtils: Elements? = null
    private var messager: Messager? = null
    private var typeUtils: Types? = null

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        filer = processingEnv.filer
        elementUtils = processingEnv.elementUtils
        messager = processingEnv.messager
        typeUtils = processingEnv.typeUtils
        //        note(processingEnv.getOptions().get("name"));
    }

    private fun note(message: String?) {
        if (message == null) {
            return
        }
        messager!!.printMessage(Diagnostic.Kind.NOTE, message)
    }

    override fun process(set: Set<TypeElement?>, roundEnvironment: RoundEnvironment): Boolean {
        if (set.isEmpty()) {
            return false
        }
        parseElement(roundEnvironment, AutoFeign::class.java)
        return true
    }

    //    @Override
    //    public Set<String> getSupportedAnnotationTypes() {
    //        Set<String> set = new HashSet<>();
    //        set.add("com.xzg.wlxx.apt.AutoFeign");
    //        return set;
    //    }
    private fun parseElement(roundEnvironment: RoundEnvironment, annotationClass: Class<out Annotation?>) {
        val elements = roundEnvironment.getElementsAnnotatedWith(annotationClass)
        for (element in elements) {
            val packageName = elementUtils!!.getPackageOf(element).qualifiedName.toString()
            val className = element.simpleName.toString()
            val elementClass = ClassName.get(packageName, className)
            mapperProcess(element, packageName, className, elementClass)
        }
        note("code generate completed")
    }

    private fun mapperProcess(element: Element, packageName: String, className: String, elementClass: ClassName) {
        val autoMapper = element.getAnnotation(AutoFeign::class.java)

        // mapper 类名
        val name = autoMapper.name.ifEmpty { className + "Mapper" }
        val baseMapperTypeMirror = readValue<TypeMirror>(element, AutoFeign::class.java, "baseMapper")


        // 处理父类BaseMapper
        var baseMapperType: ParameterizedTypeName? = null
        if (baseMapperTypeMirror != null && baseMapperTypeMirror.toString() != Void::class.java.name) {
            baseMapperType = ParameterizedTypeName.get(ClassName.get(baseMapperTypeMirror) as ClassName, elementClass)
        }

        // 构建需要生成的java类
        val builder = TypeSpec.classBuilder(name)
            .addModifiers(Modifier.PUBLIC)
            .addMethod(MethodSpec.constructorBuilder().build())
        if (baseMapperType != null) {
            builder.addSuperinterface(baseMapperType)
        }
        val javaFile = JavaFile.builder("$packageName.mapper", builder.build()).build()
        try {
            // 生成类文件
            javaFile.writeTo(filer)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    private inline fun <reified T> readValue(element: Element, clazz: Class<*>, key: String): T? {
        val am = getEventTypeAnnotationMirror(element, clazz)
        var av: AnnotationValue? = null
        if (am != null) {
            av = getAnnotationValue(am, key)
        }
        if (av == null) {
            return null
        }
        if (av.value is T?) {
            return av.value as T?
        }
        return null
    }

    private fun getEventTypeAnnotationMirror(element: Element, clazz: Class<*>): AnnotationMirror? {
        val clazzName = clazz.name
        for (annotationMirror in element.annotationMirrors) {
            if (annotationMirror.annotationType.toString() == clazzName) {
                return annotationMirror
            }
        }
        return null
    }

    private fun getAnnotationValue(annotationMirror: AnnotationMirror, key: String): AnnotationValue? {
        for ((key1, value) in annotationMirror.elementValues) {
            if (key == key1!!.simpleName.toString()) {
                return value
            }
        }
        return null
    }
}
