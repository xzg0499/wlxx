package com.xzg.wlxx.library;

import cn.hutool.json.JSONUtil;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.xzg.wlxx.common.base.BasePo;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

/**
 * @author XiaoZG
 */
public class MockUtils {

    private static final MockConfig DEFAULT_MOCK_CONFIG = MockConfig.newInstance().excludes("id"
            , "createDate", "createBy", "updateDate", "updateBy", "del");

    public static <T> T mock(Class<T> clazz) {
        return JMockData.mock(clazz, DEFAULT_MOCK_CONFIG);
    }

    public static void postRequest(MockMvc mockMvc, String uri, BasePo<?> po) {
        request(mockMvc, HttpMethod.POST, uri, po);
    }

    public static void request(MockMvc mockMvc, HttpMethod method, String uri, BasePo<?> po) {
        request(mockMvc, method, uri, JSONUtil.toJsonStr(po));
    }

    public static void request(MockMvc mockMvc, HttpMethod method, String url, String jsonStr) {
        try {
            mockMvc.perform(MockMvcRequestBuilders.request(method, URI.create(url))
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonStr)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.log());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
