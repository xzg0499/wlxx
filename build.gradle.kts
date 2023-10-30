configure(allprojects) {
    group = "com.xzg"
    version = "0.0.1"
}

tasks.register<DefaultTask>("cleanEmptyFolder") {
    group = "wlxx"
    description = "清理空文件夹"
    val file = projectDir
    val list = mutableListOf<File>();
    file.walkTopDown()
        .filter { f -> f.isDirectory }
        .filter { f -> !f.path.replace(file.path, "").startsWith("\\.") }
        .filter { it.name.startsWith("wlxx-") }
        .forEach { f ->
            var isEmpty = true;
            f.walkTopDown()
                .filter { it.path.contains("build") && it.name == "build" }
                .forEach { it.deleteRecursively() }
            f.walkTopDown()
                .forEach { isEmpty = it.listFiles()?.isEmpty() ?: false && isEmpty }
            if (isEmpty) {
                list.add(f)
            }
        }
    list.forEach {
        println(it.name)
        it.deleteRecursively()
    }
}

tasks.register<DefaultTask>("countJavaFile") {
    group = "wlxx"
    description = "统计Java文件数"
    val count = rootDir.walkTopDown()
        .filter { !it.isDirectory }
        .filter { it.name.endsWith(".java") }
        .count()
    println("java file count: $count")
}