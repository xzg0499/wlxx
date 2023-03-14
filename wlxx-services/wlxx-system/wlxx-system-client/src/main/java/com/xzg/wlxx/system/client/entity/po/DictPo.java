package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_dict")
@Schema(description = "Dict对象")
public class DictPo extends BasePo<DictPo> {


    @Schema(description = "是否启用")
    private Boolean isEnabled;

    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典值")
    private String dictValue;

    @Schema(description = "级别")
    private Integer level;

    @Schema(description = "备注")
    private String remark;


}
