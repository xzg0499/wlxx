package com.xzg.wlxx.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzgang0499
 * @since 2022-06-01
 */
@Getter
@Setter
@TableName("t_dict")
public class TDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后一次更新人
     */
    private String updater;

    /**
     * 最后一次更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 字典代码
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典层级
     */
    private Integer level;

    /**
     * 描述
     */
    private String description;


}
