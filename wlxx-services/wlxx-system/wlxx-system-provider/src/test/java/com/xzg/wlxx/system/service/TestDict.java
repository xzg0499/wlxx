package com.xzg.wlxx.system.service;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.Locale;

/**
 * @author xzgan
 * @date 2023/3/24
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class TestDict extends AbstractTestNGSpringContextTests {

    @Test
    public void test() {
        Faker faker = new Faker(Locale.CHINA);
        log.info(faker.name().fullName());
    }
}
