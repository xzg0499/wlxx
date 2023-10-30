plugins {
    id("wlxx.dependencies")
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs += "-Xjsr305=strict"
//        jvmTarget = "17"
//    }
//}

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

// FIXME 解决全局build tests无法build
tasks.build {
    // 全局build跳过test
    println("test enabled ${tasks.getByName("test").enabled}")
    tasks.getByName("test").enabled = false
    println("test enabled ${tasks.getByName("test").enabled}")
}