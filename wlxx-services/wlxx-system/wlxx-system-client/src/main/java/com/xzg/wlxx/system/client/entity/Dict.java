package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author baomidou
 * @since 2023-01-10
 */
@Getter
@Setter
@TableName("t_dict")
@ApiModel(value = "Dict对象", description = "数据字典")
public class Dict extends BasePo<Dict> {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("是否启用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty("字典编码")
    @TableField("dict_code")
    private String dictCode;

    @ApiModelProperty("字典值")
    @TableField("dict_value")
    private String dictValue;

    @ApiModelProperty("级别")
    @TableField("level")
    private Integer level;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
