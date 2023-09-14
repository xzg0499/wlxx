rootProject.name = "wlxx"

pluginManagement {
    println("aliyun pluginManagement")
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

fun loadModule(file: File) {
    file.walkTopDown()
        .filter { f -> f.isDirectory }
        .filter { f -> !f.path.replace(file.path, "").startsWith("\\.") }
        .filter { f -> f.name.startsWith("wlxx-") }
        .forEach { f ->
            val module = f.path.replace(file.path, "")
                .replace(File.separator, ":")
            include(module)
        }
}
loadModule(File("$rootDir"))


