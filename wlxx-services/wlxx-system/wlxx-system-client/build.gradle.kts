plugins {
    id("wlxx.client")
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//    openfeign 需要加入 loadbalancer
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    // https://mvnrepository.com/artifact/com.alibaba/easyexcel
    implementation("com.alibaba:easyexcel:3.3.2")
}

