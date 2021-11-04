package com.xzg.wlxx.design.builder;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:56
 */
public class LenovoComputerBuilder extends AbstractComputerBuilder{
    private Computer computer;
    public LenovoComputerBuilder(String cpu){
        computer = new Computer(cpu);
    }
    @Override
    public void setCpu() {
        computer.setCpu("Intel");
    }

    @Override
    public void setRam() {
        computer.setRam("Kingston");
    }

    @Override
    public void setUsb() {
        computer.setUsb(1);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
