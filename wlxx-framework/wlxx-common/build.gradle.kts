plugins {
    id("wlxx.client")
}

tasks.withType<JavaCompile> {
//    options.compilerArgs = listOf("-Xlint:unchecked", "-verbose", "-XprintRounds", "-Xmaxerrs", "100000", "-Akey=name")
    options.compilerArgs =
//        ALL-UNNAMED
        listOf(
//            "-Djps.track.ap.dependencies=false",
//            "--add-modules=jdk.compiler",
//            "--add-reads jdk.compiler=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED"
        )
}

dependencies {
    // FIXME Cause: superclass access check failed: class com.xzg.wlxx.apt.EnumInnerConstantProcessor$1 (in unnamed module @0x7de784ee) cannot access class com.sun.tools.javac.tree.TreeTranslator (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.tree to unnamed module @0x7de784ee
//    implementation(project(":wlxx-framework:wlxx-apt"))
//    annotationProcessor(project(":wlxx-framework:wlxx-apt"))
//    implementation(File("E:\\ITL\\wlxx\\wlxx-framework\\wlxx-apt\\build\\libs\\wlxx-apt-0.0.1-plain.jar"))
//    annotationProcessor(File("E:\\ITL\\wlxx\\wlxx-framework\\wlxx-apt\\build\\libs\\wlxx-apt-0.0.1-plain.jar"))
}

