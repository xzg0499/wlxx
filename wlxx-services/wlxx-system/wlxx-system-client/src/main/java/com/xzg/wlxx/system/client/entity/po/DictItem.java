package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
@Schema(description = "DictItem对象", defaultValue = "字典项")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictItem extends BasePo<DictItem> {


    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典名称")
    private String dictValue;

    @Schema(description = "是否启用")
    private Boolean enabled;

    @Schema(description = "字典表ID")
    @NotNull(message = "字典ID不能为空")
    private Long dictId;

    @Schema(description = "排序")
    private Integer sort;

}
