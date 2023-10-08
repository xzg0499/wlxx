package com.xzg.wlxx.system

import cn.hutool.json.JSONUtil
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import com.xzg.wlxx.system.client.entity.po.OrgPo
import com.xzg.wlxx.system.service.OrgService
import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class OrgTests {
    @Autowired
    var mockMvc: MockMvc? = null

    @Autowired
    var orgService: OrgService? = null

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun test(i: Int) {
        log.info("==========={}", i)
        val org = MockUtils.mock(OrgPo::class.java)
        MockUtils.postRequest(mockMvc, "/org/add", org)
    }

    @Test
    fun list4Tree() {
        val list = orgService!!.list4Tree(null)
        log.info("===={}", JSONUtil.toJsonStr(list))
    }
}
