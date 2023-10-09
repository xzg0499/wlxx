plugins {
    id("wlxx.client")
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

