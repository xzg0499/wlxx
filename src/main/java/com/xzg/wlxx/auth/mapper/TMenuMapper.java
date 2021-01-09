package com.xzg.wlxx.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzg.wlxx.auth.domain.TMenu;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-06
 */
public interface TMenuMapper extends BaseMapper<TMenu> {
    public String select();
}
