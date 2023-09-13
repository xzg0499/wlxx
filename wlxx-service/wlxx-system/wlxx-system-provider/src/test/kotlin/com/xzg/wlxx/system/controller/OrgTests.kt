package com.xzg.wlxx.system.controller

import cn.hutool.json.JSONUtil
import com.github.jsonzou.jmockdata.JMockData
import com.xzg.demo.BaseTests.Companion.mockConfig
import com.xzg.wlxx.system.entity.po.Org
import com.xzg.wlxx.system.service.OrgService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.IntStream

@SpringBootTest
class OrgTests {
    @Autowired
    lateinit var orgService: OrgService

    @Test
    fun testAddOrg() {
        IntStream.range(0, 10).forEach {
            val org = JMockData.mock(Org::class.java, mockConfig)
            orgService.save(org)
        }
    }

    @Test
    fun testList4Tree() {
        var list = orgService.list4Tree()
        println(JSONUtil.toJsonStr(list))
    }
}