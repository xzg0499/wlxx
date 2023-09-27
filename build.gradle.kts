configure(allprojects) {
    group = "com.xzg"
    version = "0.0.1"
}

tasks.register<DefaultTask>("cleanEmptyFolder") {
    val file = rootDir
    val list = mutableListOf<File>();
    file.walkTopDown()
        .filter { f -> f.isDirectory }
        .filter { f -> !f.path.replace(file.path, "").startsWith("\\.") }
        .filter { it.name.startsWith("wlxx-") }
        .forEach { f ->
            var isEmpty = false;
            f.walkTopDown()
                .filter { !it.path.contains("build") }
                .forEach {
                    isEmpty = it.listFiles()?.isEmpty() == true
                }
            if (isEmpty) {
                list.add(f)
            }
        }
    list.forEach {
        println(it.name)
        it.deleteRecursively()
    }
}