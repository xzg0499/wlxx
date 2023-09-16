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
    val destFile = File(dest)
    if (!destFile.exists()) {
        destFile.mkdirs();
    }
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
    val path = "E:\\ITL\\WindTerm_2.5.0_Windows_Portable_x86_64.zip"
    val dest = "E:\\ITL\\WindTerm_2.5.0_Windows_Portable_x86_64"
    unZip(path, dest)
}