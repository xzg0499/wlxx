description = "系统管理"

dependencies {
    api(project(":wlxx-framework:wlxx-web"))
    //implementation(project(":wlxx-framework:wlxx-lombok:wlxx-apt"))
    //annotationProcessor(project(":wlxx-framework:wlxx-lombok:wlxx-apt"))
    implementation(project(":wlxx-framework:wlxx-lombok:wlxx-apt"))
    annotationProcessor(project(":wlxx-framework:wlxx-lombok:wlxx-apt"))
    //annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
}

tasks.withType<JavaCompile> {
    options.compilerArgs = listOf(
        "--add-exports",
        "java.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        "-XDignore.symbol.file",
        "-Xdoclint:none",
        "-Xlint:none",
        "-nowarn"
    )
    options.isFork = true
    options.forkOptions.executable = "javac"
}