package com.xzg.wlxx.design.factory.impl;

import com.xzg.wlxx.design.factory.AbstractFactory;
import com.xzg.wlxx.design.factory.Component;
import com.xzg.wlxx.design.factory.Computer;
import com.xzg.wlxx.design.factory.MethodFactory;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 14:00
 */
public class ComputerFactory extends AbstractFactory implements MethodFactory {
    @Override
    public Component methodFactoryCreate(){
        System.out.print("（电脑工厂）生产了：");
        return new Computer();
    };

    @Override
    protected Component abstractFactoryCreate() {
        System.out.println("(抽象工厂-电脑工厂）生产了：");
        return new Computer();
    }
}
