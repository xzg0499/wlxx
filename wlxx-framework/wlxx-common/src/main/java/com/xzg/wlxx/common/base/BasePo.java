package com.xzg.wlxx.common.base;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xzg.wlxx.common.util.PojoConvertor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasePo<T extends BasePo<T>> extends Model<T> {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "id", description = "主键id", hidden = true)
    private Long id;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")
    @Schema(name = "createDate", description = "创建时间", hidden = true)
    private LocalDateTime createDate;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @Schema(name = "createBy", description = "创建人", hidden = true)
    private String createBy;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")
    @Schema(name = "updateDate", description = "更新时间", hidden = true)
    private LocalDateTime updateDate;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @Schema(name = "updateBy", description = "更新人", hidden = true)
    private String updateBy;

    @TableLogic
    @TableField(value = "del", fill = FieldFill.INSERT)
    @Schema(name = "del", description = "删除标识", defaultValue = "false", hidden = true)
    private Boolean del;

    @TableField(exist = false)
    @Schema(description = "第多少页", defaultValue = "1", hidden = true)
    private Integer page;
    @TableField(exist = false)
    @Schema(name = "size", description = "每页多少条", defaultValue = "10", hidden = true)
    private Integer size;

    public T toPo(Class<T> cls) {
        return PojoConvertor.toPo(cls, this);
    }

}
