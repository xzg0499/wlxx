package com.xzg.wlxx.user;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * @author xzgang0499
 * @date 2022-01-15
 * @since jdk1.8
 */
@SpringBootTest(classes = UserApplication.class)
public class TestUserController {

    private Faker faker;

    @BeforeEach
    public void before(){
        faker = new Faker(Locale.CHINA);
    }

    @Test
    public void test(){
        System.out.println(faker.name().name());
        System.out.println(faker.name().name());
        System.out.println(faker.name().name());
        System.out.println(faker.name().name());
        System.out.println(faker.name().name());
        System.out.println(faker.address().city());
        System.out.println(faker.address().city());
        System.out.println(faker.address().city());
        System.out.println(faker.address().city());
        System.out.println(faker.address().city());
    }
}
