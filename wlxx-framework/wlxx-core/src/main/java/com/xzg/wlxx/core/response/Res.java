package com.xzg.wlxx.core.response;

import com.xzg.wlxx.core.enums.ResEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("接口出参")
public class Res<T> implements Serializable {
    @ApiModelProperty("响应编码")
    private Integer code;
    @ApiModelProperty("消息")
    private String msg;
    @ApiModelProperty("接口是否成功")
    private Boolean success;
    @ApiModelProperty("出参数据")
    private T data;

    public Res(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Res(ResEnum resEnum) {
        this.code = resEnum.getCode();
        this.msg = resEnum.getMsg();
    }
}
