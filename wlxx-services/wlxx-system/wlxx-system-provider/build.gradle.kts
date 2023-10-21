import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}

//ext["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.system.SystemApplication"
    }
}


tasks.withType<JavaCompile> {
//    options.compilerArgs = listOf("-Xlint:unchecked", "-verbose", "-XprintRounds", "-Xmaxerrs", "100000", "-Akey=name")
//    options.compilerArgs =
//        listOf(
////            "-Djps.track.ap.dependencies=false",
//            "--add-exports",
//            "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
//            "--add-exports",
//            "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
//            "--add-exports",
//            "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
//            "--add-exports",
//            "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
//            "--add-exports",
//            "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED"
//        )
}

//dependencyManagement {
//    imports {
//        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//    }
//}


dependencies {

    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
    testImplementation(project(":wlxx-framework:wlxx-test"))
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

//    implementation("io.jsonwebtoken:jjwt-api:${property("jwtWebTokenVersion")}")
//    implementation("io.jsonwebtoken:jjwt-impl:${property("jwtWebTokenVersion")}")
//    implementation("io.jsonwebtoken:jjwt-jackson:${property("jwtWebTokenVersion")}")

    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("cn.zhxu:bean-searcher-boot-starter:4.1.2")

    // https://mvnrepository.com/artifact/com.alibaba/easyexcel
    implementation("com.alibaba:easyexcel:3.3.2")

    // pinyin 三选一
    implementation("com.github.promeg:tinypinyin:2.0.3")
//    implementation("com.belerweb:pinyin4j:2.5.1")
//    implementation("com.github.stuxuhai:jpinyin:1.1.8")

}

tasks.withType<BootBuildImage> {

}

tasks.withType<Test> {
    enabled = false
}