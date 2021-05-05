package com.xzg.wlxx.framework.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.framework.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzgang
 * @since 2021-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dict")
public class TDict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("dict_id")
    private String dictId;

    @TableField("dict_name")
    private String dictName;

    @TableField("level")
    private Integer level;

    @TableField("parent_id")
    private String parentId;

    @TableField("sort")
    private Integer sort;


}
