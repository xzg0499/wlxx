plugins {
    id("wlxx.plugin")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.3.1")
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:4.3.0")
    implementation("cn.hutool:hutool-all:5.8.21")
}

extra["springCloudVersion"] = "2022.0.4"

configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}