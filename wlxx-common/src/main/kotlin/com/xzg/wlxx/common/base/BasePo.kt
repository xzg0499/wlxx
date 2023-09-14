package com.xzg.wlxx.common.base

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.extension.activerecord.Model
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime


@Schema(name = "PO基础")
open class BasePo<T : BasePo<T>>(
    @TableId("id", type = IdType.AUTO)
    @Schema(name = "ID")
    var id: Long? = null,
    @TableField("create_date", fill = FieldFill.INSERT)
    var createDate: LocalDateTime? = null,
    @TableField("create_by", fill = FieldFill.INSERT)
    var createBy: String? = null,
    @TableField("update_date", fill = FieldFill.UPDATE)
    var updateDate: LocalDateTime? = null,
    @TableField("update_by", fill = FieldFill.UPDATE)
    var updateBy: String? = null
) : Model<T>()