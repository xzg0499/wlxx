package com.xzg.wlxx.library;

import com.xzg.wlxx.library.pojo.po.CategoryPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.stream.IntStream;

/**
 * @author XiaoZG
 */
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class CategoryTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAdd() {
        IntStream.range(0, 50).forEach(i -> {
            var po = MockUtils.mock(CategoryPo.class);
            po.insert();
        });
    }

    @Test
    public void testExport() throws Exception {
        MvcResult obj = mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/category/export"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        var response = obj.getResponse();
        var path = "E:\\users\\xiaozg\\Downloads\\demo.xlsx";
        var os = response.getContentAsByteArray();
        var file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        var bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(os);
        bos.close();
    }
}
