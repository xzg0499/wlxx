package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-03-08
 */
@Getter
@Setter
@TableName("t_dict")
@ApiModel(value = "Dict对象", description = "")
public class Dict extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典代码")
    @TableField("dict_code")
    private String dictCode;

    @ApiModelProperty("字典名称")
    @TableField("dict_name")
    private String dictName;

    @ApiModelProperty("字典层级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("壮态")
    @TableField("status")
    private Integer status;


}
