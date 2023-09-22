package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.auth.security.auth.SystemUserDetails;
import com.xzg.wlxx.system.client.entity.po.User;

import java.util.Optional;

/**
 * @author XiaoZG
 */
public interface UserService extends IService<User> {

    SystemUserDetails findByRealName(String email);

    Optional<User> findValidTokenByUserId(Long userId);


    Optional<User> findByToken(String token);
}
