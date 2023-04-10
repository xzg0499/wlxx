rootProject.name = "wlxx"

buildscript {
    pluginManagement {
        repositories {
            mavenLocal()
            maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
            maven { setUrl("https://maven.aliyun.com/repository/spring-plugin") }
            mavenLocal()
            //MPG仓库
            maven {
                name = "plugins"
                setUrl("https://plugins.gradle.org/m2/")
            }
            gradlePluginPortal()
        }
        // Resolution strategy for plugins without Plugin Marker Artifact
        //resolutionStrategy {
        //    eachPlugin {
        //        print(requested.id.id)
        //        //if (requested.id.id == 'com.xzg') {
        //        //    useModule("com.xzg:wlxx-lombok:0.0.1")
        //        //}
        //    }
        //}
        //includeBuild("wlxx-framework/wlxx-lombok")
        //plugins {
        //    id("org.springframework.boot") version "3.0.3"    // 影响springboot 打包 会产生 bootJar 任务
        //    id("io.spring.dependency-management") version "1.1.0"  // springboot默认以来管理
        //kotlin("jvm") version "1.5.31"
        //kotlin("plugin.spring") version "1.5.31"
        //kotlin("plugin.jpa") version "1.5.31"

        //kotlin("plugin.lombok") version "1.5.31"
        //id("io.freefair.lombok") version "5.3.0"
        //}
    }

}


//include(":wlxx-generator")

//def includeModule(File file, String path) {
//    file.eachDirMatch(~/wlxx-.*/) {
//        if (it.exists() && it.isDirectory()) {
//            include(path + ":" + "${it.name}")
//            includeModule(it, path + ":" + it.getName())
//        }
//    }
//}
//
//includeModule(file("${rootDir}"), "")

fun includeModule(file: File, moduleName: String) {
    file.walkTopDown()
        .filter { f -> f.isDirectory }
        .filter { f -> !f.path.replace(file.path, "").startsWith("\\.") }
        .filter { f -> f.name.startsWith("wlxx-") }
        .forEach { f ->
            run {
                var module = f.path.replace(file.path, "")
                    .replace(File.separator, ":")
                include(module)
            }
        }
}

includeModule(rootDir, "")

//include(":wlxx-framework:wlxx-core")
//include(":wlxx-framework:wlxx-web")
