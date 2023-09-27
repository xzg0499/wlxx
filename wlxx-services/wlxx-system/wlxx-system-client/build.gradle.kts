import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
    id("java-library")
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//    openfeign 需要加入 loadbalancer
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
}

tasks.withType<Jar> {
    enabled = true
}

tasks.withType<BootJar> {
    enabled = false
}