package com.xzg.wlxx.system;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @author xzgan
 * @date 2023/4/10
 */
public class TestJavaFaker {

    @Test
    public void test() {
        Faker faker = new Faker(Locale.CHINA);
        System.out.println(faker.name().fullName());
        System.out.println(faker.letterify("?????"));
        System.out.println(faker.regexify("[a-z1-9]{10}"));
        System.out.println(faker.regexify("[\\\\u4e00-\\\\u9fa5]{10}"));
    }

}
