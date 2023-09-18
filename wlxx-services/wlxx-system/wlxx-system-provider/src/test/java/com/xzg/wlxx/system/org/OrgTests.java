package com.xzg.wlxx.system.org;

import com.xzg.wlxx.system.client.entity.po.Org;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrgTests {

    @Test
    void test() {
        Org org = new Org();
        org.setId(31L);
        org.setOrgCode("test");
        org.setOrgName("test");
        org.insertOrUpdate();
    }
}
