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
        return RestResult.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> RestResult<T> msg(Integer code, String msg) {
        return RestResult.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    /**
     * 成功消息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data) {
        return RestResult.<T>builder()
                .code(ResultMsgEnum.SUCCESS.getCode())
                .msg(ResultMsgEnum.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    public static <T> RestResult<T> success() {
        return RestResult.<T>builder()
                .code(ResultMsgEnum.SUCCESS.getCode())
                .msg(ResultMsgEnum.SUCCESS.getMsg())
                .build();
    }

    /**
     * 失败消息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> failure(String msg) {
        return RestResult.<T>builder()
                .code(ResultMsgEnum.FAILURE.getCode())
                .msg(msg)
                .build();
    }


    public static <T> RestResult<T> failure() {
        return RestResult.<T>builder()
                .code(ResultMsgEnum.FAILURE.getCode())
                .msg(ResultMsgEnum.FAILURE.getMsg())
                .build();
    }

    /**
     * 异常消息
     *
     * @param ex
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> failure(Throwable ex) {
        return RestResult.<T>builder()
                .code(ResultMsgEnum.FAILURE.getCode())
                .msg(ex.getMessage())
                .build();
    }

    public static <T> RestResult<T> failure(ResultMsgEnum resultMsgEnum) {
        return RestResult.<T>builder()
                .code(resultMsgEnum.getCode())
                .msg(resultMsgEnum.getMsg())
                .build();
    }
}
