package com.xzg.wlxx.system.client.feign;

import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.client.feign.failback.UserFallback;
import com.xzg.wlxx.web.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wlxx-system", contextId = "userProvider", fallback = UserFallback.class, configuration = FeignConfiguration.class)
public interface UserProvider {

    @PostMapping("/user/findByUsername/{username}")
    UserPo findByUsername(@PathVariable(value = "username") String username);

    /**
     * @return 不能使用基础类型
     */
    @PostMapping("/user/register")
    Boolean register(@RequestBody UserDto dto);
}
