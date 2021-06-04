package com.xzg.wlxx.module.framework.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.framework.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@ApiModel(value="字典表", description="framework")
public class TDict extends BaseEntity<TDict> {

    private static final long serialVersionUID = 1L;

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
