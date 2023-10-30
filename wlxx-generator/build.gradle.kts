import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("wlxx.application")
}


tasks.withType<BootJar> {
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.JarLauncher"
        attributes["Start-Class"] = "com.xzg.wlxx.generator.GeneratorApplication"
    }
}

dependencies {
//    implementation("com.googlecode.aviator:aviator:5.3.3")
    implementation("com.github.davidfantasy:mybatis-plus-generator-ui:2.0.5")
}
