package com.xzg.wlxx.system.service;

import com.github.javafaker.Faker;
import com.xzg.wlxx.system.client.entity.po.Dict;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.Locale;
import java.util.stream.IntStream;

/**
 * @author xzgan
 * @date 2023/3/24
 */
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestDict extends AbstractTestNGSpringContextTests {

    private final Faker faker = new Faker(Locale.CHINA);

    private final IDictService dictService;

    private final IDictItemService dictItemService;

    @Test
    public void addMockDictData() {
        IntStream.range(0, 100).forEach(i -> {
            Dict po = Dict.builder()
                    .dictCode(faker.bothify("????_???", true))
                    .dictName(faker.bothify("????"))
                    .enabled(true)
                    .remark(faker.bothify("????"))
                    .levels(1)
                    .build();
            dictService.add(po);
        });
    }

    @Test
    public void mockDictItem() {
        IntStream.range(0, 100).forEach(i -> {
            DictItem dictItem = DictItem.builder()

                    .build();
            dictItemService.add(dictItem);
        });
    }


    @Test
    public void testSelectSeq() {
        dictItemService.sort(null);
    }
}
