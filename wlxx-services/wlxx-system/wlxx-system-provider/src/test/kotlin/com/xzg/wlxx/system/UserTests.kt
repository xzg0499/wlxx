package com.xzg.wlxx.system

import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import com.xzg.wlxx.system.client.entity.po.UserPo
import lombok.extern.slf4j.Slf4j
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
class UserTests {
    @Autowired
    var mockMvc: MockMvc? = null

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun test(i: Int) {
        log.info("==========={}", i)
        val user = MockUtils.mock(UserPo::class.java)
        user!!.insert()
    }
}
