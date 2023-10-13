plugins {
    id("wlxx.client")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-json")
}

dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2
    implementation("com.alibaba.fastjson2:fastjson2:2.0.41")
    implementation("com.alibaba.fastjson2:fastjson2-extension:2.0.41")
    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2-extension-spring6
    implementation("com.alibaba.fastjson2:fastjson2-extension-spring6:2.0.41")
}

