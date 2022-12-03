package com.xzg.wlxx.core.base;

import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import com.xzg.wlxx.core.base.response.RestResult;

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
    public static <T> RestResult<T> msg(Integer code, String msg, T data) {
        return new RestResult<T>(code, msg, data);
    }

    public static <T> RestResult<T> msg(Integer code, String msg) {
        return new RestResult<T>(code, msg, null);
    }

    /**
     * 成功消息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data) {
        return new RestResult<T>(ResultMsgEnum.SUCCESS.getCode(), ResultMsgEnum.SUCCESS.getMsg(), data);
    }

    public static <T> RestResult<T> success() {
        return new RestResult<T>(ResultMsgEnum.SUCCESS);
    }

    /**
     * 失败消息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> failure(String msg) {
        return new RestResult<T>(ResultMsgEnum.FAILURE.getCode(), msg, null);
    }


    public static <T> RestResult<T> failure() {
        return new RestResult<>(ResultMsgEnum.FAILURE);
    }

    /**
     * 异常消息
     *
     * @param ex
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> failure(Throwable ex) {
        return new RestResult<T>(ResultMsgEnum.FAILURE.getCode(), ex.getMessage(), null);
    }

    public static <T> RestResult<T> failure(ResultMsgEnum resultMsgEnum) {
        return new RestResult<T>(resultMsgEnum.getCode(), resultMsgEnum.getMsg(), null);
    }
}
