import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
    id("java-library")
}


tasks.withType<BootJar> {
    enabled = false
}