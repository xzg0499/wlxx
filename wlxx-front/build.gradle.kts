import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.SystemApplication"
    }
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:${property("springCloudAlibabaVersion")}")
//    {
//        exclude("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon")
//        isTransitive = false
//    }
    implementation("org.springframework.cloud:spring-cloud-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    developmentOnly("org.springframework.boot:spring-boot-devtools")


//    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
