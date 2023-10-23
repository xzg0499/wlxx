package com.xzg.wlxx.system.client.feign.failback;

import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.client.feign.UserProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallback implements UserProvider {

    @Override
    public UserPo findByUsername(String username) {
        log.debug("feign error");
        return null;
    }

    @Override
    public Boolean register(UserDto dto) {
        log.debug("feign error");
        return false;
    }
}
