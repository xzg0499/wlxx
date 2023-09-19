package com.xzg.wlxx.system.client.feign;

import com.xzg.wlxx.system.client.feign.config.FeignConfiguration;
import com.xzg.wlxx.system.client.feign.failback.OrgFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
@FeignClient(name = "wlxx-system", fallback = OrgFallback.class, configuration = FeignConfiguration.class)
public interface OrgProvider {

    @PostMapping("/org/test")
    Map<String, Object> test(@RequestBody Map<String, Object> map);
}
