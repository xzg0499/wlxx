package com.xzg.wlxx.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {

    public static void main(String[] args) throws IOException {
        String src = "E:\\ITL\\nacos-server-2.2.3.zip";
        String dest = "E:\\ITL\\nacos-server-2.2.3";
        unzip(src, dest);
    }

    public static void unzip(String src, String dest) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry ze = zis.getNextEntry();
        while (Objects.nonNull(ze)) {
            String entryPath = dest + File.separator + ze.getName();
            File entry = new File(entryPath);
            if (ze.isDirectory()) {
                if (!entry.exists()) {
                    entry.mkdirs();
                }
            } else {
                FileOutputStream fos = new FileOutputStream(entry);
                fos.write(zis.readAllBytes());
            }
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
        zis.close();
    }
}
