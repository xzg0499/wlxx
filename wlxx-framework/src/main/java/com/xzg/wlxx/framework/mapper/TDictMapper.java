package com.xzg.wlxx.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzg.wlxx.framework.entity.TDict;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzgang
 * @since 2021-05-05
 */
public interface TDictMapper extends BaseMapper<TDict> {

    public List<TDict> select();
}
