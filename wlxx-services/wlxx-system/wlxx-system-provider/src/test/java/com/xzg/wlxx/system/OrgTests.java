package com.xzg.wlxx.system;

import cn.hutool.json.JSONUtil;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class OrgTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrgService orgService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void test(int i) {
        log.info("==========={}", i);
        Org org = MockUtils.mock(Org.class);
        MockUtils.request(mockMvc, org);
    }

    @Test
    void list4Tree() {
        List<OrgVo> list = orgService.list4Tree(null);
        log.info("===={}", JSONUtil.toJsonStr(list));
    }
}
