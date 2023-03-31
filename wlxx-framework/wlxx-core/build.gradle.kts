description = "core"

//dependencyManagement {
//    // 引入依赖管理工具
//    imports {
//        mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
//        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
//    }
//
//    dependencies {
//        //dependency("org.projectlombok:lombok:${property("lombokVersion")}")
//        //dependency("com.ejlchina:bean-searcher-boot-starter:${property("beanSearcherVersion")}")
//    }
//}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

dependencies {
    //api(project(":wlxx-framework:wlxx-bom"))

    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-validation")

    /*spring boot*/

    api("org.springframework.boot:spring-boot-starter-security")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
    api("org.springframework.cloud:spring-cloud-starter-loadbalancer")

    api("javax.servlet:javax.servlet-api:4.0.1")
    //api("org.springframework.boot:spring-boot-devtools")

    api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    api("org.springframework.cloud:spring-cloud-starter-bootstrap")

    // SpringBoot / Grails 项目直接使用以下依赖，更为方便（只添加这一个依赖即可）
    api("com.ejlchina:bean-searcher-boot-starter:${property("beanSearcherVersion")}")

    /*redis*/
    api("org.springframework.boot:spring-boot-starter-data-redis")

    /*lombok*/
    api("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    //compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    //annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    //testCompileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    //testAnnotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")

    /*mybatis-plus*/
    api("com.baomidou:mybatis-plus-boot-starter:${property("mybatisPlusVersion")}")

    /*mysql*/
    api("mysql:mysql-connector-java:${property("mysqlVersion")}")
    /*postgres*/
    //api("org.postgresql:postgresql:42.5.4")

    /*knife4j*/
    //api("com.github.xiaoymin:knife4j-openapi3-spring-boot-starter:4.0.0")
    api("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:4.0.0")
    //api("com.github.xiaoymin:knife4j-spring-boot-starter:${knife4jVersion}")

    /*hutool*/
    //api("cn.hutool:utool-all:${property("hutoolVersion")}")
    api("cn.hutool:hutool-all:${property("hutoolVersion")}")

    /*fastjson*/
    api("com.alibaba:fastjson:${property("fastjsonVersion")}")


    /*pinyin4j*/
    api("com.belerweb:pinyin4j:2.5.1")

    /*jupiter*/
    //testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: "${jupiterVersion}"


    /*TODO Could not find snakeyaml-1.30-android.jar*/
    /*跟jfaker 冲突*/
    //api 'org.yaml:snakeyaml:1.28'

    /*redis-om*/
    //implementation 'com.redis.om:redis-om-spring:0.6.3'
}