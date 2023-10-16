package com.xzg.wlxx.library.entity;

import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * @author XiaoZG
 */
@Data
public class Animal {
    private String type;

    public static void main(String[] args) {
        var dog = new Dog();
        dog.setName("1");
        dog.setType("2");
        var animal = AnimalMapper.INSTANCE.toPo(dog);
        System.out.println(JSONUtil.toJsonStr(animal));
    }
}
