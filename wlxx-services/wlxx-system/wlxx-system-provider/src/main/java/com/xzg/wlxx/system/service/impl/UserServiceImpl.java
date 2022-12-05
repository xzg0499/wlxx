package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import com.xzg.wlxx.system.mapper.UserMapper;
import com.xzg.wlxx.system.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements IUserService {

    @Override
    public boolean add(UserPo po) {
        return save(po);
    }

    @Override
    public IPage<UserPo> search(UserParam param) {
        return page(param.getPage());
    }

    @Override
    public boolean enabled(Long id, boolean enabled) {
        boolean result = lambdaUpdate().set(UserPo::getIsEnabled,enabled)
                .eq(UserPo::getId,id)
                .update();
        return result;
    }

}
