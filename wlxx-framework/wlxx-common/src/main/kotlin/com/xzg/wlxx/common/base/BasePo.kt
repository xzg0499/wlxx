package com.xzg.wlxx.common.base

import com.baomidou.mybatisplus.annotation.*
import com.baomidou.mybatisplus.extension.activerecord.Model
import io.swagger.v3.oas.annotations.media.Schema
import lombok.Data
import lombok.EqualsAndHashCode
import java.time.LocalDateTime

@Data
@EqualsAndHashCode(callSuper = true)
open class BasePo<T : BasePo<T>?> : Model<T>() {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "ID")
    var id: Long? = null

    @TableField(
        value = "create_date",
        fill = FieldFill.INSERT
    ) //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")

    var createDate: LocalDateTime? = null

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    var createBy: String? = null

    @TableField(
        value = "update_date",
        fill = FieldFill.UPDATE
    ) //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")

    var updateDate: LocalDateTime? = null

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    var updateBy: String? = null

    @TableLogic
    @TableField("del")
    var del: Boolean? = null
}
