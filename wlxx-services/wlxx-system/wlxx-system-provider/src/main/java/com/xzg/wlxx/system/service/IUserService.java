package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     */
    boolean add(User po);

    /**
     * 分页查询
     */
    IPage<User> search(UserParam param);

    /**
     * 启用/禁用
     */
    boolean enabled(Long id, boolean enabled);

}
