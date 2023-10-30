import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.configuration")
}

tasks.withType<Jar> {
    enabled = false
}

tasks.withType<BootJar> {
    enabled = true
}