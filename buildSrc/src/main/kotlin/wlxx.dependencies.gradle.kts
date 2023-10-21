plugins {
    id("wlxx.plugin")
    id("wlxx.version")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    
    implementation("com.baomidou:mybatis-plus-boot-starter:${property("mybatisPlusVersion")}")
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:${property("knife4jVersion")}")
    implementation("cn.hutool:hutool-all:${property("hutoolVersion")}")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}



configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}