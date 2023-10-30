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

}




dependencies {

    implementation(project(":wlxx-services:wlxx-system:wlxx-system-client"))
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation(project(":wlxx-framework:wlxx-web"))
    testImplementation(project(":wlxx-framework:wlxx-test"))


    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("cn.zhxu:bean-searcher-boot-starter:4.1.2")


    // pinyin 三选一
    implementation("com.github.promeg:tinypinyin:2.0.3")
//    implementation("com.belerweb:pinyin4j:2.5.1")
//    implementation("com.github.stuxuhai:jpinyin:1.1.8")

}

tasks.withType<BootBuildImage> {

}

tasks.withType<Test> {
    enabled = true
}