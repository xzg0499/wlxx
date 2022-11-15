package com.xzg.wlxx.org.test;

import com.xzg.wlxx.org.OrgApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.test
 * @date 2022/11/15 10:24
 */
@SpringBootTest(classes = {OrgApplication.class})
@Slf4j
public class TestNG extends AbstractTestNGSpringContextTests {

    /**
     * FIXME 无法注入注解：@RequiredArgsConstructor(onConstructor = @__(@Autowired))
     */
    @Test
    public void test() {
        log.info("test===========");
    }
}
