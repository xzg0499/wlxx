package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzg.wlxx.common.web.base.BaseEntity;
import com.xzg.wlxx.system.client.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TDict extends BaseEntity<TDict> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
//    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("创建者")
    private String creator;

    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updater;

    @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

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

    @TableField("status")
    @ApiModelProperty("是否启用，1-启用，0-禁用")
    private StatusEnum status;

}
