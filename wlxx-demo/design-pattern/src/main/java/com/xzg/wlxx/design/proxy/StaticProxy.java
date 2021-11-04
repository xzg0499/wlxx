package com.xzg.wlxx.design.proxy;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 9:45
 */
public class StaticProxy implements Products {

    private Products products;

    public StaticProxy(Products products){
        this.products = products;
    }

    @Override
    public void showMe() {
        System.out.print("（静态代理）我代理了：");
        this.products.showMe();
        System.out.println("的销售");
    }

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new WaterPipe());
        staticProxy.showMe();
        staticProxy = new StaticProxy(new Wires());
        staticProxy.showMe();
    }
}
