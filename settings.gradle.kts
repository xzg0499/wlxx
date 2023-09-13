rootProject.name = "wlxx"

fun loadModule(file: File) {
    file.walkTopDown()
        .filter { f -> f.isDirectory }
        .filter { f -> !f.path.replace(file.path, "").startsWith("\\.") }
        .filter { f -> f.name.startsWith("wlxx-") }
        .forEach { f ->
            val module = f.path.replace(file.path, "")
                .replace(File.separator, ":")
            include(module)
        }
}
loadModule(File("$rootDir"))


