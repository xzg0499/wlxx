plugins {
    id("wlxx.client")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-json")
}

dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    api("org.springframework.boot:spring-boot-starter-aop")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")

    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2
    api("com.alibaba.fastjson2:fastjson2:2.0.41")
    api("com.alibaba.fastjson2:fastjson2-extension:2.0.41")
    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2-extension-spring6
    api("com.alibaba.fastjson2:fastjson2-extension-spring6:2.0.41")

    api("org.springframework.cloud:spring-cloud-starter-loadbalancer")

    api("org.springframework.cloud:spring-cloud-starter")
    api("org.springframework.cloud:spring-cloud-starter-bootstrap")
    api("org.springframework.boot:spring-boot-starter-aop")
    api("org.springframework.boot:spring-boot-devtools")
//    developmentOnly("org.springframework.boot:spring-boot-devtools")

    api("com.alibaba:easyexcel:3.3.2")
    {
        exclude(group = "org.apache.commons", module = "commons-compress")
    }

    api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:${property("springCloudAlibabaVersion")}")
    {
        exclude("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon")
        isTransitive = false
    }
}

