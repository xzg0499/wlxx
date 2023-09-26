plugins {
    id("wlxx.plugin")
    id("wlxx.version")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.baomidou:mybatis-plus-boot-starter:${property("mybatisPlusVersion")}")
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:${property("knife4jVersion")}")
    implementation("cn.hutool:hutool-all:${property("hutoolVersion")}")
}



configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}