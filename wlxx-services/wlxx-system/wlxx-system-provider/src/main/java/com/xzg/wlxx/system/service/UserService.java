package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.User;
import com.xzg.wlxx.system.config.security.auth.SystemUserDetails;

import java.util.Optional;

/**
 * @author XiaoZG
 */
public interface UserService extends IService<User> {

    SystemUserDetails findnByUsername(String username);

    Optional<User> findValidTokenByUserId(Long userId);


    Optional<User> findByToken(String token);
}
