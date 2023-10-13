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
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.3")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.3")
}
