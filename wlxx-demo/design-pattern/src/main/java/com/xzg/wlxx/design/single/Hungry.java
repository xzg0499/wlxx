package com.xzg.wlxx.design.single;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:30
 * 饿汉单例：饥饿模式，先建了再说
 */
public class Hungry {

    private static Hungry instance = new Hungry();

    private Hungry(){
        System.out.println("饿汉单例");
    }

    public static Hungry getInstance(){
        return instance;
    }
}
