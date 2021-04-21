package com.xzg.wlxx.module.mapper;

import com.xzg.wlxx.module.entity.TDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-01-13
 */
public interface TDictMapper extends BaseMapper<TDict> {
    public List<TDict> selectAll();
}
