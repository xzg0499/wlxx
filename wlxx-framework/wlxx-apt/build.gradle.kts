import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
    id("java-library")
}




dependencies {
    // https://mvnrepository.com/artifact/com.google.auto.service/auto-service
    implementation("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
// https://mvnrepository.com/artifact/com.squareup/javapoet
    implementation("com.squareup:javapoet:1.13.0")

}


tasks.withType<BootJar> {
    enabled = false
}