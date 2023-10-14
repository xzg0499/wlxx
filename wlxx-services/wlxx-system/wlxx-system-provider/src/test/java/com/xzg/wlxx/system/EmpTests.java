package com.xzg.wlxx.system;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xzg.wlxx.system.client.entity.po.EmpPo;
import com.xzg.wlxx.system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author XiaoZG
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class EmpTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmpService empService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void test(int i) {
        log.info("==========={}", i);
        EmpPo emp = MockUtils.mock(EmpPo.class);
        emp.setOrgId(RandomUtil.randomLong(12, 20));
        MockUtils.request(mockMvc, HttpMethod.POST, "/emp/save", emp);
    }

    @Test
    void testUpdate() {
        EmpPo emp = empService.getById(13);
        emp.setEmpName("xx");
        empService.update(emp, Wrappers.<EmpPo>lambdaUpdate().eq(EmpPo::getId, emp.getId()));
    }
}
