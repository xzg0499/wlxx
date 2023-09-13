plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.3")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.3")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.8.22")
}
