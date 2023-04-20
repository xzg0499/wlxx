package com.xzg.wlxx.flowable;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 以端口方式启动运行测试
 * <p>
 * FIXME testng在gradle中无法执行，但是此处可以编译
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
