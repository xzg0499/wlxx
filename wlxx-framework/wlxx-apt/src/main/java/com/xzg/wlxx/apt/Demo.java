package com.xzg.wlxx.apt;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

/**
 * @author XiaoZG
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        // `JavaFile` 代表 Java 文件
        JavaFile javaFile = JavaFile.builder("com.xzg.wlxx.apt",
                        // TypeSpec 代表一个类
                        TypeSpec.classBuilder("Demo")
                                // 给类添加一个属性
                                .addField(FieldSpec.builder(int.class, "mField", Modifier.PRIVATE)
                                        .build())
                                // 给类添加一个方法
                                .addMethod(MethodSpec.methodBuilder("method")
                                        .addModifiers(Modifier.PUBLIC)
                                        .returns(void.class)
                                        .addStatement("System.out.println(str)")
                                        .build())
                                .build())
                .build();

        javaFile.writeTo(System.out);
    }
}
