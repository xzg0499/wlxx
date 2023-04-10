package com.xzg.wlxx.system.service;

import com.alibaba.fastjson.JSONObject;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.xzg.wlxx.system.client.entity.po.Dict;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;
import java.util.stream.IntStream;

/**
 * @author xzgang0499
 * @date 2022-04-14
 * @since jdk1.8
 */
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AutoConfigureMockMvc
public class TestDict {

    private final MockMvc mockMvc;

    private final WebApplicationContext webApplicationContext;

    private static Faker faker = new Faker(Locale.CHINA);

    private final IDictService dictService;


//    @BeforeEach
//    public void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
////        mockMvc = MockMvcBuilders.standaloneSetup(null).build();
//    }

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

    public MvcResult post(String url, String param) throws Exception {
        log.info("param:{}", param);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(param)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.log()).andReturn();
        return result;
    }

    @Test
    public void testAddDict() throws Exception {
        JSONObject param = new JSONObject();

        Faker faker = new Faker(Locale.CHINA);

        for (int i = 0; i < 10; i++) {
            Name name = faker.name();

            //TDict dict = TDict.builder().description(name.firstName())
            //        .dictName(name.lastName())
            //        .dictCode(name.fullName())
            //        .level(i)
            //        .status(StatusEnum.NO)
            //        .build();
            //
            //MvcResult result = post("/dict/add", JSONUtil.toJsonStr(dict));
            //MockHttpServletResponse response = result.getResponse();
            //log.info("result:{}", response.getContentAsString(StandardCharsets.UTF_8));
        }
    }

    @Test
    public void testModifyDict() throws Exception {
        //TDict dict = new TDict();
        //dict.setId("0339dcc107cef4f988b886ed10d0fef8");
        //dict.selectById();
        //dict.setDictCode("修改");
    }

    @Test
    public void testFaker() {
        System.out.println(faker.business());
    }
}
