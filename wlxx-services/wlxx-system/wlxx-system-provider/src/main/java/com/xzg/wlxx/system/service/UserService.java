package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.config.security.auth.SystemUserDetails;

/**
 * @author XiaoZG
 */
public interface UserService extends IService<UserPo> {

    SystemUserDetails findnByUsername(String username);


}
