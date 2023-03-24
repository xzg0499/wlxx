package com.xzg.wlxx.core.base.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xzgang0499
 * @date 2021-12-27
 * @since jdk1.8
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class BasePo<T extends Model<?>> extends Model<T> {

    @Schema(description = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    // TODO 独立日志记录
    @Schema(description = "创建者")
    @TableField(value = "creator", fill = FieldFill.INSERT)
    private Long creator;

    @Schema(description = "创建时间")
    //@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @Schema(description = "更新人")
    @TableField(value = "updater", fill = FieldFill.UPDATE)
    private Long updater;

    @Schema(description = "更新时间")
    //@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    private Long updateTime;

    @Schema(description = "是否已删除")
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
