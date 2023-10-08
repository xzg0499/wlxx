import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}



tasks.withType<BootJar> {
    enabled = false
}