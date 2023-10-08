package com.xzg.wlxx.system

import cn.hutool.json.JSONUtil
import com.github.jsonzou.jmockdata.JMockData
import com.github.jsonzou.jmockdata.MockConfig
import com.xzg.wlxx.common.base.BasePo
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.net.URI

/**
 * @author XiaoZG
 */
object MockUtils {
    private val DEFAULT_MOCK_CONFIG = MockConfig.newInstance().excludes(
        "id", "createDate", "createBy", "updateDate", "updateBy", "del"
    )

    fun <T> mock(clazz: Class<T>?): T {
        return JMockData.mock(clazz, DEFAULT_MOCK_CONFIG)
    }

    fun postRequest(mockMvc: MockMvc?, uri: String?, po: BasePo<*>?) {
        request(mockMvc, HttpMethod.POST, uri, po)
    }

    fun request(mockMvc: MockMvc?, method: HttpMethod?, uri: String?, po: BasePo<*>?) {
        request(mockMvc, method, uri, JSONUtil.toJsonStr(po))
    }

    fun request(mockMvc: MockMvc?, method: HttpMethod?, url: String?, jsonStr: String?) {
        try {
            mockMvc!!.perform(
                MockMvcRequestBuilders.request(method!!, URI.create(url))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonStr!!)
            )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.log())
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
