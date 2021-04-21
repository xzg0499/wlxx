package com.xzg.wlxx.module.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xzg.wlxx.framework.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-01-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TDict extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("CREATE_USER")
    private String createUser;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @TableField("UPDATE_USER")
    private String updateUser;

    @TableField("DICT_ID")
    private String dictId;

    @TableField("IS_DICT_ROOT")
    private Integer isDictRoot;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("DICT_CODE")
    private String dictCode;

    @TableField("DICT_NAME")
    private String dictName;

    @TableField("STATE")
    private Integer state;


}
