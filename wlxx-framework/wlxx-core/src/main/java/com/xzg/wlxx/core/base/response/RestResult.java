package com.xzg.wlxx.core.base.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "接口出参")
public class RestResult<T> implements Serializable {
    @Schema(description = "响应编码")
    private Integer code;
    @Schema(description = "消息")
    private String msg;

    @Schema(description = "数据")
    private T data;
}
