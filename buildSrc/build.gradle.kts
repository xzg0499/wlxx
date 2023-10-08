plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    maven {
        name = "aliyun-gradle-plugin"
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.3")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.3")
    // FIXME allopen 在重复导入
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.8.22")
    implementation("org.jetbrains.kotlin:kotlin-noarg:1.8.22")
    implementation("org.jetbrains.kotlin:kotlin-lombok:1.8.22")
}
