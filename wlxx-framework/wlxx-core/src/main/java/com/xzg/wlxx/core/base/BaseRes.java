package com.xzg.wlxx.core.base;

import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import com.xzg.wlxx.core.base.response.Result;

/**
 * @author xzgan
 * @datetime 2022/5/30 20:08
 * @package com.xzg.wlxx.common.core.base
 */
public class BaseRes {

    /**
     * 消息模板
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> msg(Integer code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

    public static <T> Result<T> msg(Integer code, String msg) {
        return new Result<T>(code, msg, null);
    }

    /**
     * 成功消息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultMsgEnum.SUCCESS.getCode(), ResultMsgEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResultMsgEnum.SUCCESS);
    }

    /**
     * 失败消息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(String msg) {
        return new Result<T>(ResultMsgEnum.FAILURE.getCode(), msg, null);
    }


    public static <T> Result<T> failure() {
        return new Result<>(ResultMsgEnum.FAILURE);
    }

    /**
     * 异常消息
     *
     * @param ex
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(Throwable ex) {
        return new Result<T>(ResultMsgEnum.FAILURE.getCode(), ex.getMessage(), null);
    }

    public static <T> Result<T> failure(ResultMsgEnum resultMsgEnum) {
        return new Result<T>(resultMsgEnum.getCode(), resultMsgEnum.getMsg(), null);
    }
}
