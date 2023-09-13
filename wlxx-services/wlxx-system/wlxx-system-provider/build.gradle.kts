import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.kotlin-application")
}

tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.WlxxSystemApplicationKt"
    }
}

dependencies {
    implementation("com.github.jsonzou:jmockdata:4.1.2")
    implementation("cn.hutool:hutool-all:5.8.21")
    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
}

tasks.withType<BootBuildImage> {

}