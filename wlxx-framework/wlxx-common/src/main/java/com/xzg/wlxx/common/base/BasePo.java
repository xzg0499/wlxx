package com.xzg.wlxx.common.base;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasePo<T extends BasePo<T>> extends Model<T> {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "ID")
    private Long id;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private LocalDateTime updateDate;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    @TableLogic
    @TableField("del")
    private Boolean del;
}
