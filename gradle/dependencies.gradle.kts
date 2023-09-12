
configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.3.2")
    implementation("com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3")
}