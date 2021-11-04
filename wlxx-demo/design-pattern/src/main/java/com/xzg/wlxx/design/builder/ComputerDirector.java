package com.xzg.wlxx.design.builder;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 16:02
 */
public class ComputerDirector {
    public void makeComputer(AbstractComputerBuilder builder){
        builder.setCpu();
        builder.setRam();
        builder.setUsb();
    }

    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        AbstractComputerBuilder abstractComputerBuilder = new MacComputerBuilder("Mac");
        computerDirector.makeComputer(abstractComputerBuilder);
        Computer computer = abstractComputerBuilder.getComputer();
        System.out.println(computer.toString());

        abstractComputerBuilder = new LenovoComputerBuilder("Lenovo");
        computerDirector.makeComputer(abstractComputerBuilder);
        computer = abstractComputerBuilder.getComputer();
        System.out.println(computer.toString());
    }
}
