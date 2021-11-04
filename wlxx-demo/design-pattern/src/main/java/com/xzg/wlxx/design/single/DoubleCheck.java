package com.xzg.wlxx.design.single;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:34
 * 双检锁单例：
 */
public class DoubleCheck {
    private static DoubleCheck instance;

    private DoubleCheck(){
        System.out.println("双检锁单例");
    }

    public static DoubleCheck getInstance(){
        if(instance == null){
            synchronized (DoubleCheck.class){
                if(instance == null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
