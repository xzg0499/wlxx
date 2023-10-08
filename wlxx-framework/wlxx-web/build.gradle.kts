import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
    id("java-library")
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

tasks.withType<BootJar> {
    enabled = false
}