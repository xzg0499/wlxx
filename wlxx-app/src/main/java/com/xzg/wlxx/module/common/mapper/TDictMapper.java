package com.xzg.wlxx.module.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzg.wlxx.module.common.entity.TDict;

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

//    @Select("select * from t_dict")
    public List<TDict> select();
}
