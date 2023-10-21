package com.xzg.wlxx.system;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.xzg.wlxx.system.client.entity.po.OrgPo;
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
import java.util.Objects;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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
        OrgPo org = MockUtils.mock(OrgPo.class);
        MockUtils.postRequest(mockMvc, "/org/add", org);
    }

    @Test
    void list4Tree() {
        List<OrgVo> list = orgService.list4Tree(null);
        log.info("===={}", JSONUtil.toJsonStr(list));
    }

    @Test
    void testTree() {
        var size = RandomUtil.randomInt(5, 8);
        var deep = RandomUtil.randomInt(2, 5);
        MockUtils.mockTreeDate(size, deep, null, (l, p) -> {
                    var po = MockUtils.mock(OrgPo.class);
                    po.setOrgId(p);
                    po.setOrgLevel(deep - l - 1);
                    return po;
                }, OrgPo::getId
        );
    }


    /**
     * mock tree
     */
    private void test(int size, int deep, Object parentId) {
        int leaf = --deep;
        int finalDeep = deep;
        IntStream.range(0, size).forEach(i -> {
            var po = MockUtils.mock(OrgPo.class);
            po.setOrgId(Objects.isNull(parentId) ? null : (Long) parentId);
            po.setOrgLevel(-finalDeep);
            po.insert();
            if (leaf != 0 && RandomUtil.randomBoolean()) {
                test(RandomUtil.randomInt(5, 8), leaf, po.getId());
            }
        });
    }


}
