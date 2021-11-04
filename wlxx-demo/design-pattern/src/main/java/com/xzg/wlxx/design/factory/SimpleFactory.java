package com.xzg.wlxx.design.factory;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 11:27
 */
public class SimpleFactory {

    public Component createComponent(String className){
        Component component = null;
        try {
            System.out.print("（简单工厂）生产了：");
            //一般是通过if-else来判断type，然后直接new组件，偷懒直接用了反射来创建对象了
            component = (Component)Class.forName(String.format("com.xzg.wlxx.design.factory.%s",className)).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("无法生产该类型的配件");
        }
        return component;
    }

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.createComponent("Computer");
        simpleFactory.createComponent("Display");
        simpleFactory.createComponent("Host");
        simpleFactory.createComponent("Keyboard");
        simpleFactory.createComponent("Mouse");
        simpleFactory.createComponent("xxx");
    }
}
