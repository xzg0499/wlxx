package com.xzg.wlxx.core.base.response;

import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("接口出参")
public class RestResult<T> implements Serializable {
    @ApiModelProperty("响应编码")
    private Integer code;
    @ApiModelProperty("消息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;


    public RestResult(ResultMsgEnum resultMsgEnum) {
        this.code = resultMsgEnum.getCode();
        this.msg = resultMsgEnum.getMsg();
    }
}
