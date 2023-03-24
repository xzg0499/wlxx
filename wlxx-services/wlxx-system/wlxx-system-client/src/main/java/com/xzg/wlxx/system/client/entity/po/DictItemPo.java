package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典明细
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_dict_item")
@Schema(description = "DictItem对象", defaultValue = "字典明细")
public class DictItemPo extends BasePo<DictItemPo> {


    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典名称")
    private String dictValue;

    @Schema(description = "是否启用")
    private Boolean enabled;

    @Schema(description = "描述")
    private String desc;

    @Schema(description = "字典表ID")
    private Long dictId;

}
