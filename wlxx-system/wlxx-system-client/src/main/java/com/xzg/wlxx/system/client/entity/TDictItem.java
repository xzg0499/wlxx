package com.xzg.wlxx.system.client.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xzg.wlxx.common.core.base.BasePage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_dict_item")
@ApiModel(value = "DictItem对象", description = "")
public class TDictItem extends BasePage<TDictItem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典表主键：t_dict.id")
    private String dictId;

    @ApiModelProperty("字典项代码")
    private String dictCode;

    @ApiModelProperty("字典项名称")
    private String dictName;

    @ApiModelProperty("排序")
    private Integer sort;
}
