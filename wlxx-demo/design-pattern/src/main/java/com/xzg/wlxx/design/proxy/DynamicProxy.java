package com.xzg.wlxx.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 10:11
 */
public class DynamicProxy implements InvocationHandler {

    private Products products;

    public DynamicProxy(Products products){
        this.products = products;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("(dynamic)我代理了：");
        Object result = method.invoke(products,args);
        System.out.println("的销售");
        return result;
    }

    public static void main(String[] args) {
        Products products = (Products) Proxy.newProxyInstance(Wires.class.getClassLoader(),new Class[]{Products.class},new DynamicProxy(new Wires()));
        products.showMe();
        products = (Products) Proxy.newProxyInstance(Wires.class.getClassLoader(),new Class[]{Products.class},new DynamicProxy(new WaterPipe()));
        products.showMe();
//        dynamicProxy.invoke();
    }
}
