import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("wlxx.dependencies")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
}

tasks.withType<Test> {
    useJUnitPlatform()
}