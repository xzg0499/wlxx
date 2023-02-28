package com.xzg.wlxx.system;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class TestDictItemPo {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAddDictItem() throws Exception {
        Faker faker = new Faker(Locale.CHINA);

        for (int i = 0; i < 100; i++) {
            Name name = faker.name();

            //TDictItem item = TDictItem.builder().dictCode(name.fullName())
            //        .dictName(name.firstName())
            //        .dictId("c8924517c67322978b48ca8552d1202d").build();
            //
            //MvcResult result = mockMvc.perform(
            //        MockMvcRequestBuilders.post("/dict-item/add")
            //                .accept(MediaType.APPLICATION_JSON)
            //                .contentType(MediaType.APPLICATION_JSON)
            //                .content(JSONUtil.toJsonStr(item))
            //                .characterEncoding("UTF-8")
            //                .accept(MediaType.APPLICATION_JSON)
            //).andDo(MockMvcResultHandlers.log()).andReturn();
        }
    }
}
