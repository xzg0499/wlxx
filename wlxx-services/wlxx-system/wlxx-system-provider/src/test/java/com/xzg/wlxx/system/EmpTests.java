package com.xzg.wlxx.system;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xzg.wlxx.system.client.entity.po.Emp;
import com.xzg.wlxx.system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
public class EmpTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmpService empService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void test(int i) {
        log.info("==========={}", i);
        Emp emp = MockUtils.mock(Emp.class);
        emp.setOrgId(RandomUtil.randomLong(12, 20));
        emp.insert();
    }

    @Test
    void testUpdate() {
        Emp emp = empService.getById(13);
        emp.setEmpName("xx");
        empService.update(emp, Wrappers.<Emp>lambdaUpdate().eq(Emp::getId, emp.getId()));
    }
}
