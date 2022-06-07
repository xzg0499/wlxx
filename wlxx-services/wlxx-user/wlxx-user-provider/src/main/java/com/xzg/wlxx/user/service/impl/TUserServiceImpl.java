package com.xzg.wlxx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.user.client.entity.TUser;
import com.xzg.wlxx.user.mapper.TUserMapper;
import com.xzg.wlxx.user.service.ITUserService;
import org.springframework.stereotype.Service;

/**
* @author xzgan
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-06-07 17:31:23
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}




