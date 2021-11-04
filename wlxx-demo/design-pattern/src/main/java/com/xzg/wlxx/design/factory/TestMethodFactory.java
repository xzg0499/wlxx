package com.xzg.wlxx.design.factory;

import com.xzg.wlxx.design.factory.impl.*;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 11:57
 */
public class TestMethodFactory {

    public static void main(String[] args) {
        MethodFactory methodFactory = new ComputerFactory();
        methodFactory.methodFactoryCreate();
        new DisplayFactory().methodFactoryCreate();
        new HostFactory().methodFactoryCreate();
        new KeyboardFactory().methodFactoryCreate();
        new MouseFactory().methodFactoryCreate();
    }
}
