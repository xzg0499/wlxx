package com.xzg.wlxx.design.single;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:29
 */
public class TestSinlge {
    public static void main(String[] args) {
        Slacker.getInstance();
        Hungry.getInstance();
        DoubleCheck.getInstance();
        Singleton.getInstance();
        // 枚举方式单例
    }
}
