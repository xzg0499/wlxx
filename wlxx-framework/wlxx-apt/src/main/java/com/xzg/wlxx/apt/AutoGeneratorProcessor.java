package com.xzg.wlxx.apt;

/**
 * @author XiaoZG
 */

import com.google.auto.service.AutoService;
import com.squareup.javapoet.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SupportedAnnotationTypes({
        "com.xzg.wlxx.apt.AutoFeign" // 指定我们这个注解处理器能够处理的注解，写我们想要处理的注解
})
@SupportedSourceVersion(value = SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class AutoGeneratorProcessor extends AbstractProcessor {

    private Filer filer;
    private Elements elementUtils;
    private Messager messager;
    private Types typeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();
        typeUtils = processingEnv.getTypeUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set.isEmpty()) {
            return false;
        }
        parseElement(roundEnvironment, AutoFeign.class);
        return true;
    }

//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        Set<String> set = new HashSet<>();
//        set.add("com.xzg.wlxx.apt.AutoFeign");
//        return set;
//    }

    private void parseElement(RoundEnvironment roundEnvironment, Class<? extends Annotation> annotationClass) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(annotationClass);
        for (Element element : elements) {
            String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();
            String className = element.getSimpleName().toString();
            ClassName elementClass = ClassName.get(packageName, className);
            mapperProcess(element, packageName, className, elementClass);
        }
        messager.printMessage(Diagnostic.Kind.NOTE, "code generate completed");
    }

    private void mapperProcess(Element element, String packageName, String className, ClassName elementClass) {
        AutoFeign autoMapper = element.getAnnotation(AutoFeign.class);

        // mapper 类名
        String name = (autoMapper.name() == null || autoMapper.name().isEmpty()) ? className + "Mapper" : autoMapper.name();

        TypeMirror baseMapperTypeMirror = readValue(element, AutoFeign.class, "baseMapper");


        // 处理父类BaseMapper
        ParameterizedTypeName baseMapperType = null;
        if (baseMapperTypeMirror != null && !Objects.equals(baseMapperTypeMirror.toString(), Void.class.getName())) {
            baseMapperType = ParameterizedTypeName.get((ClassName) ClassName.get(baseMapperTypeMirror), elementClass);
        }

        // 构建需要生成的java类
        TypeSpec.Builder builder = TypeSpec.classBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(MethodSpec.constructorBuilder().build());

        if (baseMapperType != null) {
            builder.addSuperinterface(baseMapperType);
        }

        JavaFile javaFile = JavaFile.builder(packageName + ".mapper", builder.build()).build();

        try {
            // 生成类文件
            javaFile.writeTo(filer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T readValue(Element element, Class<?> clazz, String key) {
        AnnotationMirror am = getEventTypeAnnotationMirror(element, clazz);
        AnnotationValue av = null;
        if (am != null) {
            av = getAnnotationValue(am, key);
        }
        return av == null ? null : (T) av.getValue();
    }

    private AnnotationMirror getEventTypeAnnotationMirror(Element element, Class<?> clazz) {
        String clazzName = clazz.getName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (Objects.equals(annotationMirror.getAnnotationType().toString(), clazzName)) {
                return annotationMirror;
            }
        }
        return null;
    }

    private AnnotationValue getAnnotationValue(AnnotationMirror annotationMirror, String key) {
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
            if (Objects.equals(key, entry.getKey().getSimpleName().toString())) {
                return entry.getValue();
            }
        }
        return null;
    }

}
