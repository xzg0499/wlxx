package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;
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
    public UserPo findByUsername(String username) {
        return lambdaQuery().eq(UserPo::getUsername, username).oneOpt().orElse(new UserPo());
    }

    @Override
    public boolean register(UserDto dto) {
        boolean exists = lambdaQuery().eq(UserPo::getUsername, dto.getUsername())
                .exists();
        if (exists) {
            throw new BusinessException("用户已存在");
        }
        var user = UserPo.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
        return save(user);
    }
}
