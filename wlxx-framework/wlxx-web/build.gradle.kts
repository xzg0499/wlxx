plugins {
    id("wlxx.application")
}


dependencies {
    implementation(project(":wlxx-framework:wlxx-common"))
    implementation("org.springframework.boot:spring-boot-starter-aop")

}

