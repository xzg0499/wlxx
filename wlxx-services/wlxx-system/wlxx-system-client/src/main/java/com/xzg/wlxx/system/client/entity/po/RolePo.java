package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@TableName("role")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePo extends BasePo<RolePo> {

    private String roleCode;
    private String roleName;

    @Schema(description = "是否启用", defaultValue = "1")
    private Boolean enabled;
}
