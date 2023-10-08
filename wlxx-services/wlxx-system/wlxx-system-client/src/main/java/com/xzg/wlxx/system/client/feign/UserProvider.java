package com.xzg.wlxx.system.client.feign;

import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.client.feign.failback.UserFallback;
import com.xzg.wlxx.web.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "wlxx-system", contextId = "userProvider", fallback = UserFallback.class, configuration = FeignConfiguration.class)
public interface UserProvider {

    @PostMapping("/user/findByUsername/{username}")
    UserPo findByUsername(@PathVariable(value = "username") String username);

    @PostMapping("/user/register")
    boolean register(@RequestBody RegisterUserDto dto);
}
