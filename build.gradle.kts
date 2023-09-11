import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


buildscript {

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
}

plugins {
	id("java")
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "com.xzg"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

tasks.withType<JavaCompile>{
	options.encoding="UTF-8"
}

tasks.withType<BootJar>{
	manifest{
		attributes["Main-Class"]="org.springframework.boot.loader.JarLauncher"
		attributes["Start-Class"]="com.xzg.wlxx.WlxxApplicationKt"
	}
}

//bootBuildImage {
//	builder = "paketobuildpacks/builder:tiny"
////	environment = ["BP_NATIVE_IMAGE": "true"]
//	docker {
//		host = "tcp://localhost:2375"
//		tlsVerify = true
////        certPath = "/home/users/.minikube/certs"
//		builderRegistry {
//			username = "user"
//			password = "secret"
//			url = "https://docker.example.com/v1/"
//			email = "user@example.com"
//		}
//	}
//}

extra["springCloudVersion"] = "2022.0.4"

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}





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

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


allprojects {
	repositories {
		mavenLocal()
		maven {
			setUrl("https://maven.aliyun.com/repository/public/")
		}
		mavenCentral()
	}
}