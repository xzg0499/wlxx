package com.xzg.wlxx.design.builder;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:54
 */
public abstract class AbstractComputerBuilder {
    public abstract void setCpu();
    public abstract void setRam();
    public abstract void setUsb();

    public abstract Computer getComputer();
}
