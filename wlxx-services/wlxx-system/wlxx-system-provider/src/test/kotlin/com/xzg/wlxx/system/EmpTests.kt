package com.xzg.wlxx.system

import cn.hutool.core.util.RandomUtil
import com.baomidou.mybatisplus.core.toolkit.Wrappers
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import com.xzg.wlxx.system.client.entity.po.EmpPo
import com.xzg.wlxx.system.service.EmpService
import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

/**
 * @author XiaoZG
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class EmpTests {
    @Autowired
    var mockMvc: MockMvc? = null

    @Autowired
    var empService: EmpService? = null

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun test(i: Int) {
        log.info("==========={}", i)
        val emp = MockUtils.mock(EmpPo::class.java)
        emp!!.orgId = RandomUtil.randomLong(12, 20)
        emp.insert()
    }

    @Test
    fun testUpdate() {
        val emp = empService!!.getById(13)
        emp!!.empName = "xx"
        empService!!.update(emp, Wrappers.lambdaUpdate<EmpPo>().eq(EmpPo::id, emp.id))
    }
}
