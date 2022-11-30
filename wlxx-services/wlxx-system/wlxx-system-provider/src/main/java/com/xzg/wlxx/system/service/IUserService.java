package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.param.UserParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
public interface IUserService extends IService<UserPo> {

    /**
     * 添加用户
     */
    boolean add(UserPo po);

    IPage<UserPo> queryPage(UserParam param);
}
