package com.xzg.wlxx.demo.proxy;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/1/10
 */
public class StaticProxy implements IPerson{
    private IPerson iPerson;

    private StaticProxy(IPerson iPerson){
        this.iPerson = iPerson;
    }

    public static StaticProxy instance(IPerson iPerson){
        return new StaticProxy(iPerson);
    }

    @Override
    public void saySomeThing() {
        System.out.println("==============proxy saySomeThing");
        iPerson.saySomeThing();
    }
}
