package com.xzg.wlxx.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.utils.DomainUtils;
import com.xzg.wlxx.auth.domain.TUser;
import com.xzg.wlxx.auth.mapper.TUserMapper;
import com.xzg.wlxx.auth.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-15
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public int addUser(TUser user) {
        return tUserMapper.insert(user);
    }

    @Override
    public int delUser(String id) {
        return tUserMapper.deleteById(id);
    }

    @Override
    public int updateUser(TUser user) {
        return tUserMapper.updateById(user);
    }

    @Override
    public List<TUser> queryUser(TUser user) {
        Map<String,Object> param = DomainUtils.toMap(user);

        return tUserMapper.selectByMap(param);
    }
}
