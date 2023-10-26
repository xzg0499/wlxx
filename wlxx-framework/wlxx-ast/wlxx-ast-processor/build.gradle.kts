import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("wlxx.client")

    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("kapt") version "1.4.20"
}


tasks.register<Delete>("deleteGeneratedSources") {
    println("delete generated folder ===$projectDir")
    val generatedSrcRoot = file("${buildDir}/generated/source/kapt/main")
    delete(generatedSrcRoot)
    delete(file("${buildDir}/generated/sources/annotationProcessor/kapt/main"))
    delete(file("${buildDir}/generated/sources/annotationProcessor/kapt/test"))
    delete(file("${buildDir}/generated/sources/annotationProcessor/kaptKotlin/main"))
    delete(file("${buildDir}/generated/sources/annotationProcessor/kaptKotlin/test"))
}

tasks.withType<JavaCompile> {
    dependsOn("deleteGeneratedSources")
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
    kapt("com.google.auto.service:auto-service:1.1.1") {
        isTransitive = false
    }
    // https://mvnrepository.com/artifact/com.squareup/javapoet
    implementation("com.squareup:javapoet:1.13.0")
    implementation(project(":wlxx-framework:wlxx-ast:wlxx-ast-annotation"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

//    api(files("./lib/tools.jar"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xdebug -Xjsr305=strict" +
                "--add-exports" +
                "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED" +
                "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED" +
                "--add-exports" +
                "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED" +
                "--add-exports" +
                "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED" +
                "--add-exports" +
                "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED"
        jvmTarget = "17"
    }
}

