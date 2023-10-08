import org.gradle.kotlin.dsl.repositories


repositories {
    mavenLocal()
    maven {
        name = "aliyun-public"
        url = uri("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
    gradlePluginPortal()
}