package com.xzg.wlxx.system;

import cn.hutool.json.JSONUtil;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.xzg.wlxx.common.base.BasePo;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author XiaoZG
 */
public class MockUtils {

    private static final MockConfig DEFAULT_MOCK_CONFIG = MockConfig.newInstance().excludes("id"
            , "createDate", "createBy", "updateDate", "updateBy");

    public static <T> T mock(Class<T> clazz) {
        return JMockData.mock(clazz, DEFAULT_MOCK_CONFIG);
    }

    public static void request(MockMvc mockMvc, BasePo po) {
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/org/add")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(JSONUtil.toJsonStr(po))
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.log());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
