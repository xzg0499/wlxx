plugins {
    id("wlxx.kotlin-camunda")
}

dependencyManagement {
    imports {
        mavenBom("org.camunda.bpm:camunda-bom:7.19.0")
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.9")
//        mavenBom("org.camunda.bpm:camunda-bom:7.20.0-alpha5")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")

    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest")
    implementation("org.camunda.bpm:camunda-engine-plugin-spin")
    implementation("org.camunda.spin:camunda-spin-dataformat-all")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.sun.xml.bind:jaxb-impl:2.3.6")
    implementation("org.camunda.bpm:camunda-engine-rest-openapi:7.19.0")
    implementation("com.github.xiaoymin:knife4j-openapi3-spring-boot-starter:4.3.0")

}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


