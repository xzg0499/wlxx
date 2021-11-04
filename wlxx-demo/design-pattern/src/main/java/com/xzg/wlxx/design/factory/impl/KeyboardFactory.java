package com.xzg.wlxx.design.factory.impl;

import com.xzg.wlxx.design.factory.Component;
import com.xzg.wlxx.design.factory.Keyboard;
import com.xzg.wlxx.design.factory.MethodFactory;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 14:01
 */
public class KeyboardFactory implements MethodFactory {
    @Override
    public Component methodFactoryCreate() {
        System.out.print("（键盘工厂）生产了：");
        return new Keyboard();
    }
}
