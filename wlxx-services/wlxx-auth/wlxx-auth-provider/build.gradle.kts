import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.auth.AuthApplication"
    }
}


dependencies {
    implementation(project(":wlxx-services:wlxx-auth:wlxx-auth-client"))
    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("io.jsonwebtoken:jjwt-api:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-impl:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-jackson:${property("jwtWebTokenVersion")}")

}
