package com.xzg.wlxx.common.core.base;

import com.xzg.wlxx.common.core.response.ResponseResult;
import com.xzg.wlxx.common.core.enums.ResponseEnum;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
public class BaseController {

    /**
     * 消息模板
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> msg(Integer code, String msg, T data){
        return new ResponseResult<T>(code,msg,data);
    }

    public static <T> ResponseResult<T> msg(Integer code, String msg){
        return new ResponseResult<T>(code,msg,null);
    }

    /**
     * 成功消息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<T>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 失败消息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failure(String msg){
        return new ResponseResult<T>(ResponseEnum.FAILURE.getCode(),msg,null);
    }

    public static <T> ResponseResult<T> failure(Integer code, String msg){
        return new ResponseResult<T>(code,msg,null);
    }

    /**
     * 异常消息
     * @param ex
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failure(Throwable ex){
        return new ResponseResult<T>(ResponseEnum.FAILURE.getCode(),ex.getMessage(),null);
    }

    public static <T> ResponseResult<T> failure(ResponseEnum responseEnum){
        return new ResponseResult<T>(responseEnum.getCode(),responseEnum.getMsg(),null);
    }


}
