package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto;
import com.xzg.wlxx.system.client.entity.po.UserPo;

/**
 * @author XiaoZG
 */
public interface UserService extends IService<UserPo> {

    UserPo findByUsername(String username);

    boolean register(RegisterUserDto dto);
}
