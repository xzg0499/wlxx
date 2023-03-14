package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Dict对象")
public class Dict extends BasePo {

    private static final long serialVersionUID = 1L;

    @Schema(description = "字典代码")
    @TableField("dict_code")
    private String dictCode;

    @Schema(description = "字典名称")
    @TableField("dict_name")
    private String dictName;

    @Schema(description = "字典层级")
    @TableField("level")
    private Integer level;

    @Schema(description = "描述")
    @TableField("description")
    private String description;

    @Schema(description = "壮态")
    @TableField("status")
    private Integer status;


}
