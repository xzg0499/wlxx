package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("dict")
public class DictPo extends BasePo<DictPo> {
    private String dictCode;
    private String dictName;

    @Schema(description = "是否启用", defaultValue = "1")
    private Boolean enabled;
}
