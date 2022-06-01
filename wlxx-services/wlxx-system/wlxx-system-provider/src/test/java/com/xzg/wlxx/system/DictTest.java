package com.xzg.wlxx.system;

import com.alibaba.fastjson.JSONObject;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.controller.TDictController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

/**
 * @author xzgang0499
 * @date 2022-04-14
 * @since jdk1.8
 */
@SpringBootTest(classes = SystemApplication.class)
@Slf4j
@AutoConfigureMockMvc
public class DictTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    TDictController tDictController;

    @BeforeEach
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(null).build();
    }

    public MvcResult post(String url,String param) throws Exception {
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
        MvcResult result = post("/dict/add",param.toJSONString());
        MockHttpServletResponse response = result.getResponse();
        System.out.println(response.getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testModifyDict() throws Exception {
        TDict dict = new TDict();
        dict.setId("0339dcc107cef4f988b886ed10d0fef8");
        dict.selectById();
        dict.setDictCode("修改");
        tDictController.modify(dict);
    }


}
