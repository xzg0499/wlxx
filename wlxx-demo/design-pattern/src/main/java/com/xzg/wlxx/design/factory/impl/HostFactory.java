package com.xzg.wlxx.design.factory.impl;

import com.xzg.wlxx.design.factory.Component;
import com.xzg.wlxx.design.factory.Host;
import com.xzg.wlxx.design.factory.MethodFactory;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 14:00
 */
public class HostFactory implements MethodFactory {
    @Override
    public Component methodFactoryCreate() {
        System.out.print("（主机工厂）生产了：");
        return new Host();
    }
}
