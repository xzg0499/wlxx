plugins {
    id("wlxx.client")
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    api("com.github.jsonzou:jmockdata:4.1.2")
    api("org.springframework.boot:spring-boot-starter-test")
}

//configurations.all() {
//    isTransitive = true
//}
