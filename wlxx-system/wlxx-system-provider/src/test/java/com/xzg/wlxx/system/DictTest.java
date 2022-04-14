package com.xzg.wlxx.system;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.xzg.wlxx.system.client.entity.TDict;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
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


    @BeforeEach
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(null).build();
    }

    public MvcResult post(String url,String param) throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/dict/add")
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
    public void demo(){
        log.info("test running");
    }
}
