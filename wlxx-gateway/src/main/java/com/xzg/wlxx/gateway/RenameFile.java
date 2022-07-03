package com.xzg.wlxx.gateway;

import java.io.File;

/**
 * @author xzgan
 * @date 2022/6/27
 */
public class RenameFile {
    public static void main(String[] args) {
        String filepath = "E:\\Project\\wlxx-blog\\source\\_posts\\迁移WizNote";

        File file = new File(filepath);
        rename(file);
    }

    public static void rename(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                rename(f);
                continue;
            }

            System.out.println(f.getAbsolutePath());
        }
    }
}
