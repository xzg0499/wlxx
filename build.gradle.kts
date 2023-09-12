import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.jetbrains.kotlin.allopen.gradle.SpringGradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin


buildscript {
//    apply("gradle/repository.gradle.kts")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    apply("gradle/version.gradle.kts")

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:3.1.3")
        classpath("io.spring.gradle:dependency-management-plugin:1.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.8.22")
    }
}

//apply("script/dependencies.gradle.kts")
//plugins {
//    id("java")
//    id("org.springframework.boot") version "3.1.3"
//    id("io.spring.dependency-management") version "1.1.3"
//    kotlin("jvm") version "1.8.22"
//    kotlin("plugin.spring") version "1.8.22"
//}
//id 'org.springframework.boot' version '3.1.3'
//id 'io.spring.dependency-management' version '1.1.3'
//id 'org.jetbrains.kotlin.jvm' version '1.8.22'
//id 'org.jetbrains.kotlin.plugin.spring' version '1.8.22'

//tasks.withType<BootJar> {
//    manifest {
//        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
//        attributes["Start-Class"] = "com.xzg.wlxx.WlxxApplicationKt"
//    }
//}


configure(allprojects) {
    group = "com.xzg"
    version = "0.0.1-SNAPSHOT"
    apply("$rootDir/gradle/repository.gradle.kts")
}

configure<Project>(subprojects) {

    val subList = subprojects.filter { f -> f.name.startsWith("wlxx-") }
    if (subList.isNotEmpty()) {
        return@configure
    }

    apply<JavaPlugin>()
    apply<SpringBootPlugin>()//org.springframework.boot
    apply<DependencyManagementPlugin>()//io.spring.dependency-management
    apply<KotlinPluginWrapper>()//jvm
    apply<SpringGradleSubplugin>()//plugin-spring

    configure<io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
//            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        }
    }

//    apply("$rootDir/gradle/dependencies.gradle.kts")
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        compileOnly("org.projectlombok:lombok")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        runtimeOnly("com.mysql:mysql-connector-j")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.baomidou:mybatis-plus-boot-starter:3.5.3.2")
        implementation("com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

