package com.xzg.wlxx.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.auth.domain.TUser;
import com.xzg.wlxx.auth.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-15
 */
public interface ITUserService extends IService<TUser> {
    public int addUser(TUser user);
    public int delUser(String id);
    public int updateUser(TUser user);
    public List<TUser> queryUser(TUser user);
}
