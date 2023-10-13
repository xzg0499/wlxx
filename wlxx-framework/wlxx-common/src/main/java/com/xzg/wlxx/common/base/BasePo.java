package com.xzg.wlxx.common.base;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasePo<T extends BasePo<T>> extends Model<T> {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "id", title = "主键id")
    private Long id;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")
    @Schema(name = "createDate", title = "创建时间")
    private LocalDateTime createDate;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @Schema(name = "createBy", title = "创建人")
    private String createBy;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GTM+8")
    @Schema(name = "updateDate", title = "更新时间")
    private LocalDateTime updateDate;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @Schema(name = "updateBy", title = "更新人")
    private String updateBy;

    @TableLogic
    @TableField("del")
    @Schema(name = "del", title = "删除标识", defaultValue = "false")
    private Boolean del;

    @TableField(exist = false)
    private Integer page;
    @TableField(exist = false)
    @Schema(name = "size", defaultValue = "10")
    private Integer size;

    public T toPo(Class<T> cls) {
        T obj = null;
        try {
            obj = cls.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        BeanUtil.copyProperties(this, obj);
        return obj;
    }

    // 子类无法引用到
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
