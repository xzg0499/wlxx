package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.xzg.wlxx.common.core.base.BasePage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author xzg
 * @since 2022-05-15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_dict")
@ApiModel(value = "TDict对象", description = "")
public class TDict extends BasePage<TDict> {

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


}
