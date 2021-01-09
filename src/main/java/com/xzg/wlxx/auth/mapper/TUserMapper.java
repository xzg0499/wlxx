package com.xzg.wlxx.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzg.wlxx.auth.domain.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-11-15
 */
public interface TUserMapper extends BaseMapper<TUser> {
//    et 用于mapper.xml识别对象
//    public int updateById(@Param("et")TUser user);
//    public List<TUser> query(TUser user);
}
