plugins {
    id("wlxx.application")
}

extra["camundaVersion"] = "7.20.0-alpha5"

dependencyManagement {
    imports {
        mavenBom("org.camunda.bpm:camunda-bom:${property("camundaVersion")}")
//        mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.3")
    }
}

dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))

//    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest")
    implementation("org.camunda.bpm:camunda-engine-plugin-spin")
    implementation("org.camunda.spin:camunda-spin-dataformat-all")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-security")
//    implementation("org.springframework.boot:spring-boot-starter-jdbc")
//    implementation("com.sun.xml.bind:jaxb-impl:2.3.6")
    implementation("org.camunda.bpm:camunda-engine-rest-openapi:${property("camundaVersion")}")
//    compileOnly("jakarta.servlet:jakarta.servlet-api")
//    compileOnly("jakarta.servlet:jakarta.activation-api")

}




