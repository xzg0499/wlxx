package com.xzg.wlxx.apt;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.util.Collections;
import java.util.Set;

/**
 * @author XiaoZG
 */
@AutoService(Processor.class)
public class WlxxProcessor extends BaseProcessor {
    public static final String ROOT_INIT = RouterManager.INIT_PACKAGE;
    public static final String INIT_CLASS = RouterManager.INIT_SIMPLE_CLASS;
    public static final String INIT_METHOD = RouterManager.INIT_METHOD;

    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //if (annotations == null || annotations.isEmpty()) {
        //    return false;
        //}
        //try {
        //    String className = "";
        //    for (Element elementItem : roundEnv.getElementsAnnotatedWith(InheritProperty.class)) {
        //        if (!(elementItem instanceof TypeElement)) {
        //            continue;
        //        }
        //        //获取注解中的内容
        //        TypeElement element = (TypeElement) elementItem;
        //        className = element.getQualifiedName().toString();
        //        String uri = element.getAnnotation(InheritProperty.class).toString();
        //
        //        // 方法内的代码是对注解挨个调用了register()方法 mainMethodBuilder.addStatement("$T.getInstance().register($S,$S)", RouterManager.class, uri, className);
        //    }
        //    log.info("==={}", className);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    log.error("异常：{}", e.getMessage());
        //}
        if (annotations == null || annotations.isEmpty()) {
            return false;
        }
        note("start==={}", annotations.size());

        try {
            //使用javapoet来动态生成代码:初始化函数init()
            MethodSpec.Builder mainMethodBuilder = MethodSpec.methodBuilder(INIT_METHOD)
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class);
            String className = "";
            for (Element elementItem : roundEnv.getElementsAnnotatedWith(AutoFeign.class)) {
                if (!(elementItem instanceof TypeElement)) {
                    continue;
                }
                //获取注解中的内容
                TypeElement element = (TypeElement) elementItem;
                className = element.getQualifiedName().toString();
                String uri = element.getAnnotation(AutoFeign.class).toString();
                // 方法内的代码是对注解挨个调用了register()方法 mainMethodBuilder.addStatement("$T.getInstance().register($S,$S)", RouterManager.class, uri, className);
            }

//            Class<?> cls = Class.forName(className);
//            POJOHandler pojoHandler = new POJOHandler();
//            byte[] bytes = pojoHandler.getClassBytes(cls);
//            pojoHandler.injectMethod(cls, bytes);
//            note("OK===");


            //使用javapoet来动态生成代码:初始化类com.bc.router.TestRouterInit
            TypeSpec testRouterInit = TypeSpec.classBuilder(INIT_CLASS)
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(mainMethodBuilder.build())
                    .build();

            JavaFile javaFile = JavaFile.builder(ROOT_INIT, testRouterInit)
                    .build();
            Filer filer = processingEnv.getFiler();
//            javaFile.writeTo(filer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(AutoFeign.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


}
