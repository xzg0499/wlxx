buildscript {
    // 引入外部gradle文件
    apply(from = "./gradle/version.gradle.kts")

    repositories {
        mavenLocal()
        maven {
            name = "aliyun"
            setUrl("https://maven.aliyun.com/repository/gradle-plugin")
        }
        // MPG仓库
        maven {
            name = "plugins"
            setUrl("https://plugins.gradle.org/m2/")
        }
        maven { setUrl("https://repo.spring.io/plugins-snapshot") }
    }

    dependencies {
        classpath("com.bmuschko:gradle-docker-plugin:6.7.0")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:3.0.5")
        classpath("cn.mycommons:buildSrc:3.4.2.1")
        classpath("io.spring.gradle:dependency-management-plugin:1.1.0")
    }

}

//plugins {
//    id("io.spring.gradle:dependency-management-plugin") version "1.1.0"
//}

configure(allprojects) {
    group = "com.xzg"
    version = "0.0.1"

    repositories {
        mavenLocal()
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/spring") }
        maven { setUrl("https://maven.aliyun.com/repository/jcenter") }
        maven { setUrl("https://maven.aliyun.com/repository/apache-snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/releases") }
        maven { setUrl("https://maven.aliyun.com/repository/snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/grails-core") }
        maven { setUrl("https://maven.aliyun.com/repository/mapr-public") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/spring-plugin") }
        mavenCentral()
    }
}



configure(subprojects) {
    //println(projectDir)
    // 定义只打包末级

    val subList = subprojects.filter { f -> f.name.startsWith("wlxx-") }
    if (subList.isNotEmpty()) {
        return@configure
    }


    //apply(plugin = "java")
    ////apply(plugin = "kotlin")
    //apply(plugin = "idea")
    //apply(plugin = "org.springframework.boot")
    //apply(plugin = "io.spring.dependency-management")
    //apply(plugin = "com.github.johnrengelman.shadow")
    apply {
        plugin("java")
        plugin("idea")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
    //apply(from = rootDir.path + "/gradle/version.gradle.kts")
    //apply(plugin: "cn.mycommons.mpg")
    //apply(from: rootDir.path + "/gradle/mpg.gradle")

    if (projectDir.name == "wlxx-core"
        || projectDir.name == "wlxx-web"
        || projectDir.name == "wlxx-test"
        || projectDir.name == "wlxx-bom"
        || projectDir.name.endsWith("-client")
    ) {
        apply(plugin = "java-library")
    }


    // java编译的时候缺省状态下会因为中文字符而失败
    //[compileJava, compileTestJava, javadoc]*.options*.encoding = 'UTF-8'

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // 编译环境 JDK17
    //sourceCompatibility = JavaVersion.VERSION_17
    //targetCompatibility = JavaVersion.VERSION_17

    tasks.withType<Jar> {
        enabled = true
    }


    //tasks.withType<BootJar> {
    //}

    tasks.named("bootJar") {
        enabled = projectDir.name.endsWith("-provider")
    }

    buildDir = File("./out")


    //dependencyManagement {
    //    // 引入依赖管理工具
    //    imports {
    //        mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
    //        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    //        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
    //        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    //    }
    //}
    ////
    ////// TODO lombok 不能使用api的方式引入
    //dependencies {
    //    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    //    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    //    testCompileOnly("org.projectlombok:lombok:${lombokVersion}")
    //    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    //}
    //apply(from = rootDir.path + "/wlxx-framework/wlxx-bom/build.gradle.kts")
    configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        }
    }
    configurations {

    }

    dependencies {
        "compileOnly"("org.projectlombok:lombok")
        "annotationProcessor"("org.projectlombok:lombok")
        "testCompileOnly"("org.projectlombok:lombok")
        "testAnnotationProcessor"("org.projectlombok:lombok")
    }
    //configurations.all {
    //    dependencies {
    //        implementation("org.projectlombok:lombok:${property("lombokVersion")}")
    //        annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    //    }
    //}


    tasks.withType<Test> {
        enabled = false
        reports {
            html
            enabled
        }
        useJUnitPlatform() { }
    }


    //configurations {
    //    implementation {
    //        resolutionStrategy.failOnVersionConflict()
    //    }
    //}
}



