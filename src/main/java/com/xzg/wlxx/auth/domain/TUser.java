package com.xzg.wlxx.auth.domain;

import com.baomidou.mybatisplus.annotation.TableField;

import com.baomidou.mybatisplus.annotation.TableId;
import com.xzg.wlxx.framework.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TUser extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    @TableField("USERNAME")
    private String username;

    @TableField("LOGINNAME")
    private String loginname;

    @TableField("PASSWORD")
    private String password;

}
