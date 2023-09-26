import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}

//ext["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"
ext["springCloudAlibabaVersion"] = "2022.0.0.0"
extra["jwtWebTokenVersion"] = "0.11.5"

tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.SystemApplication"
    }
}


//dependencyManagement {
//    imports {
//        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//    }
//}

dependencies {
    testImplementation("com.github.jsonzou:jmockdata:4.1.2")
    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
    implementation(project(":wlxx-framework:wlxx-common"))
    annotationProcessor(project(":wlxx-framework:wlxx-apt"))
//    testCompileOnly("org.projectlombok:lombok")
//    testAnnotationProcessor("org.projectlombok:lombok")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:${property("springCloudAlibabaVersion")}")
//    {
//        exclude("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon")
//        isTransitive = false
//    }
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:2022.0.0.0")
    implementation("org.springframework.cloud:spring-cloud-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("io.jsonwebtoken:jjwt-api:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-impl:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-jackson:${property("jwtWebTokenVersion")}")

//    implementation("org.springframework.boot:spring-boot-starter-websocket")
}

tasks.withType<BootBuildImage> {

}