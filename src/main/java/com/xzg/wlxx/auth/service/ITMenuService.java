package com.xzg.wlxx.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.auth.domain.TMenu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-06
 */
public interface ITMenuService extends IService<TMenu> {
    public String select();
}
