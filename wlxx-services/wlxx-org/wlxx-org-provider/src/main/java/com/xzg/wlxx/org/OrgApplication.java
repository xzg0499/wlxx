package com.xzg.wlxx.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org
 * @date 2022/11/10 14:45
 */
@SpringBootApplication
//FIXME 暂时使用
@ComponentScan(basePackages = {"com.xzg.wlxx.web", "com.xzg.wlxx.core"})
public class OrgApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrgApplication.class, args);
    }
}
