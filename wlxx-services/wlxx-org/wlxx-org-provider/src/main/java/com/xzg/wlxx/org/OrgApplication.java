package com.xzg.wlxx.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org
 * @date 2022/11/10 14:45
 */
@SpringBootApplication
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.xzg.wlxx.core.base.controller.BaseController"})})
public class OrgApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrgApplication.class, args);
    }
}
