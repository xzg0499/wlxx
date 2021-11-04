package com.xzg.wlxx.design.builder;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 15:44
 */
@Data
public class Computer {
    private String brand;
    private String cpu;
    private String ram;
    private int usb;
    private String keyboard;
    private String display;

    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usb = builder.usb;
    }

    public Computer(String brand){
        this.brand = brand;
    }

    private static class Builder{
        private String cpu;
        private String ram;
        private int usb;

        public Builder setCpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram){
            this.ram = ram;
            return this;
        }

        public Builder setUsb(int usb){
            this.usb = usb;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        Computer computer = new Computer.Builder().setCpu("Intel").setRam("Kingston").setUsb(2).build();
        System.out.println(computer.toString());
    }

    @Override
    public String toString() {
        return String.format("%s-Computer{%s}",this.brand, JSONObject.toJSONString(this));
    }
}
