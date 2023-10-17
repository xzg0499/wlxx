package com.xzg.wlxx.apt;

/**
 * @author XiaoZG
 */

import com.squareup.javapoet.*;

import javax.annotation.processing.*;
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

//@SupportedAnnotationTypes({
//        "com.xzg.wlxx.apt.AutoFeign" // 指定我们这个注解处理器能够处理的注解，写我们想要处理的注解
//})
//@SupportedSourceVersion(value = SourceVersion.RELEASE_17)
//@AutoService(Processor.class)
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
//        note(processingEnv.getOptions().get("name"));
    }

    private void note(String message) {
        if (message == null) {
            return;
        }
        messager.printMessage(Diagnostic.Kind.NOTE, message);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set.isEmpty()) {
            return false;
        }
        parseElement2(roundEnvironment, AutoFeign.class);
        return true;
    }

    /**
     * https://github.com/JustryDeng/CommonRepository/tree/master/%E3%80%90JSR269%E5%AE%9E%E6%88%98%E3%80%91%E4%B9%8B%E7%BC%96%E8%AF%91%E6%97%B6%E6%93%8D%E4%BD%9CAST%EF%BC%8C%E4%BF%AE%E6%94%B9%E5%AD%97%E8%8A%82%E7%A0%81%E6%96%87%E4%BB%B6%EF%BC%8C%E4%BB%A5%E5%AE%9E%E7%8E%B0%E5%92%8Clombok%E7%B1%BB%E4%BC%BC%E7%9A%84%E5%8A%9F%E8%83%BD
     *
     * @param roundEnvironment
     * @param annotationClass
     */
    private void parseElement2(RoundEnvironment roundEnvironment, Class<? extends Annotation> annotationClass) {
        Set<? extends Element> set = roundEnvironment.getElementsAnnotatedWith(AutoFeign.class);
        set.forEach(e -> {

        });
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
        note("code generate completed");
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
