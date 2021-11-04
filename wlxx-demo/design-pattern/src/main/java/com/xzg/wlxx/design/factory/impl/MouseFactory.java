package com.xzg.wlxx.design.factory.impl;

import com.xzg.wlxx.design.factory.Component;
import com.xzg.wlxx.design.factory.MethodFactory;
import com.xzg.wlxx.design.factory.Mouse;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 14:01
 */
public class MouseFactory implements MethodFactory {
    @Override
    public Component methodFactoryCreate() {
        System.out.print("（鼠标工厂）生产了：");
        return new Mouse();
    }
}
