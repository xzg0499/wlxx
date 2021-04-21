package com.xzg.wlxx.demo;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/4/20
 */
public class BatchRenameFile {
    public static void main(String[] args) throws Exception{
        String filePath = "E:\\笔记";
        File file = new File(filePath);
//        System.out.println(file.getPath());
        renameFile(file);
        System.out.println("compeleted rename file!");
//        String s = "E:\\笔记\\wlxx.md.txt";
//        System.out.println(s.replaceAll("\\.*\\.*$",".md"));
    }
    public static void renameFile(File file) throws Exception{
        if(!file.isFile()){
            File[] files = file.listFiles();
            assert files != null;
            for(File f : files){
                renameFile(f);
            }
        }else{
            String filename = file.getName();
            String filePath = file.getPath();
            File newFile = new File(filePath.replaceAll(".txt",""));
            file.renameTo(newFile);
        }

    }
}
