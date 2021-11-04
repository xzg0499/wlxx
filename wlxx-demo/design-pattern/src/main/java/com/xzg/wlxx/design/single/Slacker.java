package com.xzg.wlxx.design.single;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:26
 * 懒汉单例：需要的时候才创建
 */
public class Slacker {
    private static Slacker instance;

    private Slacker(){
        System.out.println("懒汉单例");
    }

    public static Slacker getInstance(){
        if(instance == null){
            instance = new Slacker();
        }
        return instance;
    }
}
