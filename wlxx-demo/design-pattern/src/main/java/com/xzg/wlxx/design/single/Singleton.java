package com.xzg.wlxx.design.single;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:37
 * 静态内部类
 */
public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){
        System.out.println("静态内部类");
    }

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
