plugins {
    id("wlxx.client")
}


tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
    options.compilerArgs.addAll(
        listOf(
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
    )

}


dependencies {
    // https://mvnrepository.com/artifact/com.google.auto.service/auto-service
    implementation("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
    // https://mvnrepository.com/artifact/com.squareup/javapoet
    implementation("com.squareup:javapoet:1.13.0")
    implementation(project(":wlxx-framework:wlxx-ast:wlxx-ast-annotation"))

}
