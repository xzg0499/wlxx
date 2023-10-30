import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.configuration")
    id("java-library")
}

tasks.withType<Jar> {
    enabled = true
    archiveClassifier.set("")
    // TODO build自动发布maven包
    tasks.getByName("publishMavenPublicationToMavenLocal")
}

tasks.withType<BootJar> {
    enabled = false
}