plugins {
    //id("io.freefair.lombok") version "8.0.1"
    //id("org.ow2.asm") version "9.4"
    id("java-library")
    java
    //id 'java-gradle-plugin'
    //id 'com.gradle.plugin-publish' version '1.0.0'
    //id 'maven-publish'
    //kotlin("jvm") version "1.8.20"
    //kotlin("plugin.spring") version "1.7.22"
    //id("kotlin")
}

//apply plugin: "LombokPlugin"

dependencies {
    //println(System.getProperty("java.home").toString())
    //implementation(file(System.getProperty("java.home").toString() + "/lib/tools.jar"))
    //extra["home"] = System.properties['java.home']
    //compileOnly(files("${property("home")}/lib/tools.jar"))

    //implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")
    //println(Jvm.current().toolsJar)
    //implementation(files(Jvm.current().toolsJar))

    implementation(project(":wlxx-framework:wlxx-core"))
    implementation("com.google.auto.service:auto-service:1.0.1")
    annotationProcessor("com.google.auto.service:auto-service:1.0.1")
}


//tasks.withType<JavaCompile> {
//    options.encoding = "UTF-8"
//    sourceCompatibility = "17"
//    targetCompatibility = "17"
//    //options.compilerArgs = listOf("--add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED")
//    //options.compilerArgs = listOf(
//    //    "--add-opens java.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
//    //    "--add-opens java.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
//    //)
//}

// 打包sourcesJar任务
//task sourcesJar(type: Jar, dependsOn: classes) {
//    classifier 'source'
//    from sourceSets.main.allSource
//}


//compileJava.options.encoding = 'UTF-8'
//compileJava.sourceCompatibility = "17"
//compileJava.targetCompatibility = "17"

// 打包javadocJar任务
//task javadocJar(type: Jar, dependsOn: javadoc) {
//    //classifier = 'source'
//    javadoc.options {
//        encoding = "GBK"
//    }
//    from javadoc.destinationDir
//}

//gradlePlugin {
//    plugins {
//        lombokPlugin {
//            id = "com.xzg"
//            version(version)
//            displayName = 'wlxx-lombok'
//            description = 'A gradle plugin that simplifies the usage of the Lombok annotation processor.'
//            implementationClass = 'com.xzg.wlxx.lombok.LombokPlugin'
//        }
//    }
//    //mavenCoordinates {
//    //    artifactId = archivesBaseName
//    //}
//}


//pluginBundle {
//    //website = 'https://github.com/franzbecker/gradle-lombok'
//    //vcsUrl = 'https://github.com/franzbecker/gradle-lombok.git'
//    tags = ['gradle', 'lombok']
//
//    //plugins {
//    //    lombokPlugin {
//    //        id = 'com.xzg.wlxx.lombok'
//    //    }
//    //}
//
//    //mavenCoordinates {
//    //    groupId = 'com.xzg.wlxx'
//    //    artifactId = 'wlxx-lombok'
//    //}
//}

//tasks.compileJava {
//    dependsOn("")
//}

//publishing {
//    publications {
//        mavenJava(MavenPublication) {
//            groupId project.group
//            artifactId project.name
//            version project.version
//            // components.java jar包
//            // components.web war包
//            from components.java
//
//            // 增加 sourcesJar、javadocJar 任务
//            //artifact sourcesJar
//            //artifact javadocJar
//        }
//    }
//    repositories {
//        mavenLocal()
//    }
//}

//artifacts {
//    archives sourcesJar
//}

//build {
//    buildDir = "./out"
//}

//configurations {
//compileOnly {
//    extendsFrom annotationProcessor
//}
//}
//generateEffectiveLombokConfig {
//lombok.log.fieldName = foobar
//}

//tasks.withType(JavaCompile) {
//    // Try to turn them all off automatically
//    options.compilerArgs << '-Xlint:none'
//    options.compilerArgs << '-nowarn' // same as '-Xlint:none'
//
//    // Turn them off manually
//    options.compilerArgs << '-Xlint:-auxiliaryclass'
//    options.compilerArgs << '-Xlint:-cast'
//    options.compilerArgs << '-Xlint:-classfile'
//    options.compilerArgs << '-Xlint:-deprecation'
//    options.compilerArgs << '-Xlint:-dep-ann'
//    options.compilerArgs << '-Xlint:-divzero'
//    options.compilerArgs << '-Xlint:-empty'
//    options.compilerArgs << '-Xlint:-fallthrough'
//    options.compilerArgs << '-Xlint:-finally'
//    options.compilerArgs << '-Xlint:-options'
//    options.compilerArgs << '-Xlint:-overloads'
//    options.compilerArgs << '-Xlint:-overrides'
//    options.compilerArgs << '-Xlint:-path'
//    options.compilerArgs << '-Xlint:-processing'
//    options.compilerArgs << '-Xlint:-rawtypes'
//    options.compilerArgs << '-Xlint:-serial'
//    options.compilerArgs << '-Xlint:-static'
//    options.compilerArgs << '-Xlint:-try'
//    options.compilerArgs << '-Xlint:-unchecked'
//    options.compilerArgs << '-Xlint:-varargs'
//}


//uploadArchives {
//    repositories.mavenDeployer {
//        //repository(url: uri('../release'))
//        pom.groupId = groupId
//        pom.version = version
//        pom.artifactId = artifactId
//    }
//}


afterEvaluate {
    println("${name}:配置完成")
}

//gradle.addBuildListener( new BuildListener() {
//
//    void buildStarted(Gradle var1) {
//        println 'buildStarted()->开始构建'
//    }
//
//    void settingsEvaluated(Settings var1) {
//        println 'settingsEvaluated()->settings评估完成（settins.gradle中代码执行完毕）'
//        // var1.gradle.rootProject 这里访问Project对象时会报错，还未完成Project的初始化
//    }
//
//    void projectsLoaded(Gradle var1) {
//        println 'projectsLoaded()->项目结构加载完成（初始化阶段结束）'
//        println 'projectsLoaded()->初始化结束，可访问根项目：' + var1.gradle.rootProject
//    }
//
//    void projectsEvaluated(Gradle var1) {
//        println 'projectsEvaluated()->所有项目评估完成（配置阶段结束）'
//    }
//
//    void buildFinished(BuildResult var1) {
//        println 'buildFinished()->构建结束 '
//    }
//})