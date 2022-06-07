package com.xzg.wlxx.common.core.response;

import com.xzg.wlxx.common.core.enums.ResEnum;
import lombok.Data;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@Data
public class Res<T> {
    private Integer code;
    private String msg;
    private Boolean success;
    private T data;

    public Res(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Res(ResEnum resEnum){
        this.code = resEnum.getCode();
        this.msg = resEnum.getMsg();
    }
}
