package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@TableName("menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuPo extends BasePo<MenuPo> {

    private String code;
    private String name;
    private String icon;
    private String path;
    @Schema(name = "isOpen", title = "是否展开", defaultValue = "false")
    private Boolean isOpen;
    private Integer menuLevel;
    private Long menuId;
    private Integer sort;
}
