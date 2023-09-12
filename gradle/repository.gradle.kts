repositories {
    mavenLocal()
    maven {
        name = "aliyun"
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    // MPG仓库
    maven {
        name = "plugins"
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven { url = uri("https://repo.spring.io/plugins-snapshot") }
    maven {
        url = uri("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
    maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
    mavenLocal()
    gradlePluginPortal()
}