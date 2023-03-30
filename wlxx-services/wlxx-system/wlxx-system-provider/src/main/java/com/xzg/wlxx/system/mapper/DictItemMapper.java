package com.xzg.wlxx.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import com.xzg.wlxx.system.client.entity.vo.DictSeqVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
public interface DictItemMapper extends BaseMapper<DictItem> {

    @Select("SELECT (@rownum := @rownum + 1) AS rownum,td.* from t_dict td,(SELECT @rownum := 0)  rn")
    List<DictSeqVo> selectHasSeq();
}
