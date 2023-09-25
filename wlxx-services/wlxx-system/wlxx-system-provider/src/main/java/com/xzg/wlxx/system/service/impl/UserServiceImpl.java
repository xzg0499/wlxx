package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.config.security.auth.SystemUserDetails;
import com.xzg.wlxx.system.mapper.UserMapper;
import com.xzg.wlxx.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZG
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {


    @Override
    public SystemUserDetails findnByUsername(String username) {
        UserPo user = lambdaQuery().eq(UserPo::getUsername, username).oneOpt().orElse(new UserPo());
        SystemUserDetails userDetails = new SystemUserDetails();
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        return userDetails;
    }


}
