package com.xzg.wlxx.system;

import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.test.MockUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author XiaoZG
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserTests {

    @Autowired
    MockMvc mockMvc;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void test(int i) {
        log.info("==========={}", i);
        UserPo user = MockUtils.mock(UserPo.class);
        user.insert();
    }
}
