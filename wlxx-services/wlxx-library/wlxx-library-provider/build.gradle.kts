import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}

//ext["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.library.LibraryApplication"
    }
}


tasks.withType<JavaCompile> {

}



dependencies {
    implementation(project(":wlxx-services:wlxx-library:wlxx-library-client"))
    testImplementation(project(":wlxx-framework:wlxx-test"))
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))

    implementation("cn.zhxu:bean-searcher-boot-starter:4.1.2")

    // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
//    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    // https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor
//    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

}

tasks.withType<BootBuildImage> {

}

