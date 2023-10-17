plugins {
    id("wlxx.client")
}


tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
//    ALL-UNNAME
    options.compilerArgs =
        listOf(
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.api=wlxx.apt",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.tree=wlxx.apt",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.util=wlxx.apt",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.processing=wlxx.apt",
            "--add-exports",
            "jdk.compiler/com.sun.tools.javac.code=wlxx.apt"
        )
}


dependencies {
    // https://mvnrepository.com/artifact/com.google.auto.service/auto-service
    implementation("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
    // https://mvnrepository.com/artifact/com.squareup/javapoet
    implementation("com.squareup:javapoet:1.13.0")

}
