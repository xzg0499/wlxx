package com.xzg.wlxx.demo.proxy;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/1/10
 */
public class Programmer implements IPerson{
    @Override
    public void saySomeThing() {
        System.out.println("i am a programe");
    }
}
