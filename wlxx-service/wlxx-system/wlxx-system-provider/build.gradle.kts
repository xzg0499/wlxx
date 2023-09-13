import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.kotlin-application")
}

tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.DemoApplicationKt"
    }
}

dependencies {
    implementation("com.github.jsonzou:jmockdata:4.1.2")
    implementation("cn.hutool:hutool-all:5.8.21")
}