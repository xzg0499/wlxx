plugins {
    id("wlxx.client")
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
    
}

dependencies {
    // FIXME Cause: superclass access check failed: class com.xzg.wlxx.apt.EnumInnerConstantProcessor$1 (in unnamed module @0x7de784ee) cannot access class com.sun.tools.javac.tree.TreeTranslator (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.tree to unnamed module @0x7de784ee
//    implementation(project(":wlxx-framework:wlxx-apt:wlxx-apt-annotation"))
    implementation(project(":wlxx-framework:wlxx-ast:wlxx-ast-annotation"))
    annotationProcessor(project(":wlxx-framework:wlxx-ast:wlxx-ast-processor"))
//    implementation(File("E:\\ITL\\wlxx\\wlxx-framework\\wlxx-apt\\build\\libs\\wlxx-apt-0.0.1-plain.jar"))
//    annotationProcessor(File("E:\\ITL\\wlxx\\wlxx-framework\\wlxx-apt\\build\\libs\\wlxx-apt-0.0.1-plain.jar"))
}

