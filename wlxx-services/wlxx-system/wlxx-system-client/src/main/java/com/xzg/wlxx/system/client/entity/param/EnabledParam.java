package com.xzg.wlxx.system.client.entity.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 启用/禁用
 *
 * @author xzgan
 * @date 2023/3/24
 */
@Data
@Schema(description = "启用/禁用入参")
public class EnabledParam {

    @Schema(description = "ID", defaultValue = "0")
    private Long id;

    @Schema(description = "是否启用", defaultValue = "true")
    private Boolean enabled;
}
