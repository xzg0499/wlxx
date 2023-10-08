package com.xzg.wlxx.common.util

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import java.util.zip.ZipInputStream

object ZipUtils {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val src = "E:\\ITL\\nacos-server-2.2.3.zip"
        val dest = "E:\\ITL\\nacos-server-2.2.3"
        unzip(src, dest)
    }

    @Throws(IOException::class)
    fun unzip(src: String?, dest: String) {
        val zis = ZipInputStream(FileInputStream(src))
        var ze = zis.nextEntry
        while (Objects.nonNull(ze)) {
            val entryPath = dest + File.separator + ze.name
            val entry = File(entryPath)
            if (ze.isDirectory) {
                if (!entry.exists()) {
                    entry.mkdirs()
                }
            } else {
                val fos = FileOutputStream(entry)
                fos.write(zis.readAllBytes())
            }
            zis.closeEntry()
            ze = zis.nextEntry
        }
        zis.close()
    }
}
