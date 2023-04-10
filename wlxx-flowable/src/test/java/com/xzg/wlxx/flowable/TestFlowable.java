package com.xzg.wlxx.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

/**
 * 以端口方式启动运行测试
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.flowable
 * @date 2022/11/22 14:43
 */
@SpringBootTest(classes = FlowableApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestFlowable extends AbstractTransactionalTestNGSpringContextTests {

    @Test
    public void test() {
        System.out.println("========");
    }
}
