package com.xzg.wlxx.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.xzg.wlxx.common.core.pojo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_dict_item")
@ApiModel(value = "DictItem对象", description = "")
public class TDictItem extends BaseEntity<TDictItem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典表主键：t_dict.id")
    private String dictId;

    @ApiModelProperty("字典项代码")
    private String dictCode;

    @ApiModelProperty("字典项名称")
    private String dictName;

    @ApiModelProperty("排序")
    private Integer sort;
}
