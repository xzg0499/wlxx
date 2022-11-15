package com.xzg.wlxx.org.test;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.test
 * @date 2022/11/12 15:54
 */
public class TestJMockData {

    @Test
    public void test() {
        IntStream.range(0, 10).forEach(i -> {
            System.out.println(JMockData.mock(String.class
                    , MockConfig.newInstance().sizeRange(10, 10)
            ));
        });
    }
}
