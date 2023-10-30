package com.xzg.wlxx.system;

import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.test.MockUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.IntStream;

/**
 * @author XiaoZG
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class DictTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test() {
        IntStream.range(1, 10).forEach(i -> {
            var po = MockUtils.mock(DictPo.class);
            po.insert();
        });
    }
}
