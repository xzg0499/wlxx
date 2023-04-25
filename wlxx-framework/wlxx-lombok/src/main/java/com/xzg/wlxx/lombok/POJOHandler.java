package com.xzg.wlxx.lombok;

/**
 * @author xzgan
 * @date 2023/3/29
 */

import cn.hutool.core.io.FileUtil;
import org.springframework.asm.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用ASM字节码框架 往POJO类注入getter setter 方法
 */
public class POJOHandler {

    private ClassReader reader;
    private ClassWriter writer;
    private ClassVisitor cv;
    private File file;


    /**
     * Java中数据类型和Java字节码中数据类型的表示方式的对应关系
     */
    private static class TypeList {
        private static final Map<String, String> typeMap = new HashMap<>(7);
        private static final Map<String, Class> classMap = new HashMap<>(7);

        static {
            typeMap.put("String", "Ljava/lang/String;");
            typeMap.put("Integer", "Ljava/lang/Integer;");
            typeMap.put("Double", "Ljava/lang/Double;");
            typeMap.put("Float", "Ljava/lang/Float;");
            typeMap.put("Short", "Ljava/lang/Short;");
            typeMap.put("Boolean", "Ljava/lang/Boolean;");
            typeMap.put("Long", "Ljava/lang/Long;");

            classMap.put("String", String.class);
            classMap.put("Integer", Integer.class);
            classMap.put("Double", Double.class);
            classMap.put("Float", Float.class);
            classMap.put("Short", Short.class);
            classMap.put("Boolean", Boolean.class);
            classMap.put("Long", Long.class);
        }

        public static String getType(String type) {
            return typeMap.get(type);
        }

        public static Class getClass(String type) {
            return classMap.get(type);
        }

    }

    /**
     * 获取当前要注入Getter/Setter的类的.class文件 (电脑硬盘上)
     * 将.class文件内容按照字节形式读取上来解析
     *
     * @param currentClass
     * @return
     */
    public byte[] getClassBytes(Class currentClass) throws IOException {
        // 获取当前类的全名 data.Person
        String className = currentClass.getName();
        // 读取电脑硬盘上的当前工程下当前类的.class文件 将类全名转化成data/Person.class
        String fileName = className.replace(".", "/") + ".class";
        // 使用ClassLoader类加载器获取电脑硬盘上的当前工程下当前类的.class文件路径
        String classFilePath = ClassLoader.getSystemResource(fileName).getPath();
        // 创建File对象 映射到硬盘上的文件
        file = new File(classFilePath);
        // 使用commons-io-2.7.jar包下的文件工具 将文件内容以字节形式读取上来
        byte[] classBytes = FileUtil.readBytes(file);

        return classBytes;
    }

    /**
     * 通过类的属性 通过字节码创建方法 往方法内注入组成方法的字节码
     *
     * @param currentClass
     * @param classBytes   要被ClassReader解析的类文件的字节码
     */
    public void injectMethod(Class currentClass, byte[] classBytes) throws IOException {
        // 获取类的 包名加类名 格式化成文件路径的形式
        String classFullName = currentClass.getName().replace(".", "/");
        // 获取这个类的全部属性
        Field[] fields = currentClass.getDeclaredFields();
        // 用ASM提供的ClassReader解析字节码
        reader = new ClassReader(classBytes);
        // ASM提供的ClassWriter 生成最终修改过的字节码
        writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        // 开始访问 并开始修改类的字节码结构
        cv = new ClassVisitor(Opcodes.ASM5, writer) {
            @Override
            public void visitEnd() {

                // 循环类的属性 给每一个属性加Getter Setter方法
                for (Field field : fields) {
                    // 获取属性名字
                    String fieldName = field.getName();
                    // 将属性名字第一个字母大写 拼装成方法名 name-->Name
                    String fieldUpperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    // 获取属性在字节码里表示的类型
                    String typeSimpleName = field.getType().getSimpleName();
                    // 获取属性的类型在字节码中的形式 String --> Ljava/lang/String;
                    String fieldCodeType = TypeList.getType(typeSimpleName);
                    // 获取属性类型的class
                    Class fieldType = TypeList.getClass(typeSimpleName);

                    // get set 方法名
                    String getMethodName = "get" + fieldUpperName;
                    String setMethodName = "set" + fieldUpperName;

                    // TODO get方法
                    // 需要一个MethodVisit访问类中的方法 生成get方法
                    // 参数：权限修饰符、方法名、方法参数列表和返回值类型、方法签名、免责条款
                    MethodVisitor getMV = cv.visitMethod(Opcodes.ACC_PUBLIC, getMethodName, "()" + fieldCodeType, null, null);
                    getMV.visitCode();
                    // 往方法内注入字节码指令
                    // 1.获取方法内的this
                    getMV.visitVarInsn(Opcodes.ALOAD, 0);
                    // 2.                 获取属性的指令     属性所属的类        属性名字         属性的类型
                    getMV.visitFieldInsn(Opcodes.GETFIELD, classFullName, fieldName, Type.getDescriptor(fieldType));
                    // 3.将属性的值返回出去
                    getMV.visitInsn(Opcodes.ARETURN);
                    // 4.设置栈大小和局部变量表大小
                    getMV.visitMaxs(2, 1);
                    if (getMV != null) {
                        getMV.visitEnd();
                    }

                    // TODO set方法                                                                set方法有参数无返回值(Void)
                    MethodVisitor setMV = cv.visitMethod(Opcodes.ACC_PUBLIC, setMethodName, "(" + fieldCodeType + ")V", null, null);
                    setMV.visitCode();
                    // 获取this
                    setMV.visitVarInsn(Opcodes.ALOAD, 0);
                    // 获取参数列表中的第一个数
                    setMV.visitVarInsn(Opcodes.ALOAD, 1);
                    // 给属性赋值
                    setMV.visitFieldInsn(Opcodes.PUTFIELD, classFullName, fieldName, fieldCodeType);
                    // void方法要加上return指令
                    setMV.visitInsn(Opcodes.RETURN);
                    setMV.visitMaxs(2, 2);
                    if (setMV != null) {
                        setMV.visitEnd();
                    }

                }
            }
        };
        // 解析字节码文件 并执行ClassVisitor中的重写的方法
        reader.accept(cv, 0);

        // 将最终修改好的字节码 用ClassWriter将其转成byte[]形式 写回文件
        byte[] bytesModified = writer.toByteArray();
        FileUtil.writeBytes(bytesModified, file);
    }

    //public static void main(String[] args) throws IOException {
    //    generatorMethod();
    //    testMethod();
    //}

    //public static void generatorMethod() throws IOException {
    //    Class<?> cls = Animal.class;
    //    POJOHandler pojoHandler = new POJOHandler();
    //    byte[] bytes = pojoHandler.getClassBytes(cls);
    //    pojoHandler.injectMethod(cls, bytes);
    //    System.out.println("OK");
    //}
    //
    //public static void testMethod() {
    //    Animal animal = new Animal();
    //    //animal.setName("Dog");
    //    //animal.setAge(1);
    //    System.out.println(JSONUtil.toJsonStr(animal));
    //}

}

