package com.xzg.wlxx.auth.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("MENU_NAME")
    private String menuName;

    @TableField("URL")
    private String url;

    @TableField("PARENT_ID")
    private String parentId;


}
