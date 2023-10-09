import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}

//ext["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"
ext["springCloudAlibabaVersion"] = "2022.0.0.0"

tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.SystemApplication"
    }
}

dependencies {
    implementation(project(":wlxx-framework:wlxx-web"))
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("com.github.xiaoymin:knife4j-gateway-spring-boot-starter:4.3.0")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:${property("springCloudAlibabaVersion")}")
    {
        exclude("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon")
        isTransitive = false
    }
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:${property("springCloudAlibabaVersion")}")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

}

