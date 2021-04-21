package com.xzg.wlxx.demo.proxy;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/1/10
 */
public class Test {
    public static void main(String[] args) {
        IPerson p = StaticProxy.instance(new Programmer());
        p.saySomeThing();
    }
}
