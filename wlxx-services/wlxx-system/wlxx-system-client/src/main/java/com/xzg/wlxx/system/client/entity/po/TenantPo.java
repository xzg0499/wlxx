package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@TableName("tenant")
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantPo extends BasePo<TenantPo> {

    @Schema(title = "用户TenantId")
    private String tenantId;
    private String tenantName;

    @Schema(description = "是否启用", defaultValue = "1")
    private Boolean enabled;
}
