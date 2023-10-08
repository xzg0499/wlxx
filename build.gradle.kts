configure(allprojects) {
    group = "com.xzg"
    version = "0.0.1"
}

tasks.register<DefaultTask>("cleanEmptyFolder") {
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