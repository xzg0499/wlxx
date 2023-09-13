package com.xzg.wlxx.system.util

import java.io.File
import java.util.zip.ZipInputStream

fun renameFile(path: String, dest: String): Unit {
    val file = File(path)
    file.renameTo(File(dest))
}

fun unZip(path: String, dest: String) {
    val file = File(path)
    val zip = ZipInputStream(file.inputStream())
    var zipEntry = zip.nextEntry
    while (zipEntry != null) {
        val entryPath = dest + File.separator + zipEntry.name
        val entryFile = File(entryPath)
        if (zipEntry.isDirectory) {
            entryFile.mkdirs()
        } else {
            entryFile.writeBytes(zip.readBytes())
        }
        zip.closeEntry()
        zipEntry = zip.nextEntry
    }
    zip.close()
}

fun main() {
    println("Hello World!")
    val path = "E:\\ITL\\demo\\gradle.zip"
    val dest = "E:\\ITL\\demo\\gradlezip"
    unZip(path, dest)
}