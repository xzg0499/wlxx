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
@TableName("t_dict")
@ApiModel(value = "Dict对象", description = "")
public class TDict extends BaseEntity<TDict> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典代码")
    private String dictCode;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典层级")
    private Integer level;

    @ApiModelProperty("描述")
    private String description;
}
