package com.xzg.wlxx.design.adapter;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 16:31
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        this.specificRequest();
    }
}
