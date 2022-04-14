package com.xzg.wlxx.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xzgang0499
 * @date 2022-04-14
 * @since jdk1.8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePage<T extends BaseEntity<?>> extends BaseEntity<T>{

    @TableField(exist = false)
    @ApiModelProperty("页码")
    private Integer pageNo;
    @TableField(exist = false)
    @ApiModelProperty("一页多少")
    private Integer pageSize;
}
