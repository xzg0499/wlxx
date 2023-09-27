package com.xzg.wlxx.system.client.feign.failback;

import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.client.feign.UserProvider;

public class UserFallback implements UserProvider {

    @Override
    public UserPo findByUsername(String username) {
        return null;
    }

    @Override
    public boolean register(RegisterUserDto dto) {
        return false;
    }
}