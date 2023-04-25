description = "系统管理"

dependencies {
    api(project(":wlxx-framework:wlxx-web"))
    implementation(project(":wlxx-framework:wlxx-lombok"))
    annotationProcessor(project(":wlxx-framework:wlxx-lombok"))
    //annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
}

