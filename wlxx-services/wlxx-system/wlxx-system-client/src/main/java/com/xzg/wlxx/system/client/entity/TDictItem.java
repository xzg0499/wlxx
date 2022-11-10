package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzg.wlxx.common.web.base.BaseEntity;
import com.xzg.wlxx.system.client.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TDictItem extends BaseEntity<TDictItem> {

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("字典表主键：t_dict.id")
    private String dictId;

    @ApiModelProperty("字典项代码")
    private String dictCode;

    @ApiModelProperty("字典项名称")
    private String dictName;

    @ApiModelProperty("排序")
    private Integer sort;

    @TableField("status")
    @ApiModelProperty("是否启用，1-启用，0禁用")
    private StatusEnum status;
}
