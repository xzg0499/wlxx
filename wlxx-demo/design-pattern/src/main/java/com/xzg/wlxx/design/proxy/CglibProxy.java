package com.xzg.wlxx.design.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 11:14
 * CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多。
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式要更为合适一些。同时由于CGLib由于是采用动态创建子类的方法，对于final修饰的方法无法进行代理。
 */
public class CglibProxy implements MethodInterceptor {

    private Products products;

    public Products getProducts(Products products){
        this.products = products;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.products.getClass());
        enhancer.setCallback(this);
        return (Products) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.print("（cglib)我代理了：");
        Object result = method.invoke(products,objects);
        System.out.println("的销售");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Products products = cglibProxy.getProducts(new WaterPipe());
        products.showMe();
        products = cglibProxy.getProducts(new Wires());
        products.showMe();
    }
}
