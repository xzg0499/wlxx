package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.auth.security.auth.SystemUserDetails;
import com.xzg.wlxx.system.client.entity.po.User;
import com.xzg.wlxx.system.mapper.UserMapper;
import com.xzg.wlxx.system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author XiaoZG
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public SystemUserDetails findByRealName(String realName) {
        User user = lambdaQuery().eq(User::getRealName, realName).one();
        SystemUserDetails userDetails = new SystemUserDetails();
        BeanUtil.copyProperties(user, userDetails);
        return userDetails;
    }

    @Override
    public Optional<User> findValidTokenByUserId(Long userId) {
        return Optional.ofNullable(getById(userId));
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional.ofNullable(lambdaQuery().eq(User::getToken, token).one());
    }
}
