package com.xzg.wlxx.common.core.base;

import com.xzg.wlxx.common.core.enums.ResponseEnum;
import com.xzg.wlxx.common.core.response.Res;

/**
 * @author xzgan
 * @datetime 2022/5/30 20:08
 * @package com.xzg.wlxx.common.core.base
 */
public class BaseRes {

    /**
     * 消息模板
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Res<T> msg(Integer code, String msg, T data){
        return new Res<T>(code,msg,data);
    }

    public static <T> Res<T> msg(Integer code, String msg){
        return new Res<T>(code,msg,null);
    }

    /**
     * 成功消息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Res<T> success(T data){
        return new Res<T>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 失败消息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Res<T> failure(String msg){
        return new Res<T>(ResponseEnum.FAILURE.getCode(),msg,null);
    }

    public static <T> Res<T> failure(Integer code, String msg){
        return new Res<T>(code,msg,null);
    }

    /**
     * 异常消息
     * @param ex
     * @param <T>
     * @return
     */
    public static <T> Res<T> failure(Throwable ex){
        return new Res<T>(ResponseEnum.FAILURE.getCode(),ex.getMessage(),null);
    }

    public static <T> Res<T> failure(ResponseEnum responseEnum){
        return new Res<T>(responseEnum.getCode(),responseEnum.getMsg(),null);
    }
}
