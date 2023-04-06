package com.xzg.wlxx.liteflow.demo;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.liteflow.demo
 * @date 2022/12/28 9:28
 */
@Component("c")
public class CComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("CComponent execute");
    }
}
