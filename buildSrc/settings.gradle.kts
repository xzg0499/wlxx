rootProject.name = "buildSrc"

pluginManagement {
    println("aliyun pluginManagement buildSrc")
    repositories {
        mavenLocal()
        maven {
            name = "aliyun-gradle-plugin"
            url = uri("https://maven.aliyun.com/repository/gradle-plugin")
        }
        maven {
            name = "aliyun-spring-plugin"
            url = uri("https://maven.aliyun.com/repository/spring-plugin")
        }
        gradlePluginPortal()
    }
}


