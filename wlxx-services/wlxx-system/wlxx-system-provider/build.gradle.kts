import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

//buildscript {
//    dependencies {
//        // TODO 解决data final class问题
//        classpath("org.jetbrains.kotlin:kotlin-noarg:1.8.22")
//        classpath("org.jetbrains.kotlin:kotlin-allopen:1.8.22")
//    }
//}

plugins {
    id("wlxx.application")
//    kotlin("plugin.noarg")
//    kotlin("plugin.lombok")
}

//noArg {
//    annotation("lombok.NoArgsConstructor")
//}
//allOpen {
//    annotation("lombok.NoArgsConstructor")
//}

//kotlinLombok {
//    lombokConfigurationFile(file("lombok.config"))
//}

//ext["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.SystemApplicationKt"
    }
}


tasks.withType<JavaCompile> {
//    options.compilerArgs = listOf("-Xlint:unchecked", "-verbose", "-XprintRounds", "-Xmaxerrs", "100000", "-Akey=name")
}

//dependencyManagement {
//    imports {
//        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//    }
//}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-json")
}

dependencies {
    testImplementation("com.github.jsonzou:jmockdata:4.1.2")
    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
//    annotationProcessor(project(":wlxx-framework:wlxx-apt"))
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:${property("springCloudAlibabaVersion")}")
//    {
//        exclude("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon")
//        isTransitive = false
//    }
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:2022.0.0.0")
    implementation("org.springframework.cloud:spring-cloud-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("io.jsonwebtoken:jjwt-api:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-impl:${property("jwtWebTokenVersion")}")
    implementation("io.jsonwebtoken:jjwt-jackson:${property("jwtWebTokenVersion")}")

//    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("cn.zhxu:bean-searcher-boot-starter:4.1.2")
    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2
    implementation("com.alibaba.fastjson2:fastjson2:2.0.41")
    implementation("com.alibaba.fastjson2:fastjson2-extension:2.0.41")
    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2-extension-spring6
    implementation("com.alibaba.fastjson2:fastjson2-extension-spring6:2.0.41")
    // https://mvnrepository.com/artifact/com.alibaba/easyexcel
    implementation("com.alibaba:easyexcel:3.3.2")

    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    implementation(kotlin("coroutines"))

}

tasks.withType<BootBuildImage> {

}