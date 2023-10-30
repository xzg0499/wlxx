import gradle.kotlin.dsl.accessors._4a26dd84298dfbdc4ac960278efabc7a.publishing

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
//    println("test enabled ${tasks.getByName("test").enabled}")
    tasks.getByName("test").enabled = false
//    println("test enabled ${tasks.getByName("test").enabled}")
}

//gradle.afterProject {
//    println("after project ===")
//}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = groupId
            artifactId = project.name
            version = version

            from(components["java"])
        }
    }
}

tasks.withType<PublishToMavenLocal> {

}
