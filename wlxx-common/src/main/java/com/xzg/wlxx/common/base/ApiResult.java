package com.xzg.wlxx.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {
    private Integer code;
    private String msg;
    private T data;
    private Throwable ex;

    public static <T> ApiResult<T> message(String msg) {
        return message(200, msg);
    }

    public static <T> ApiResult<T> message(Integer code, String msg) {
        return ApiResult.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T> ApiResult<T> success(String msg, T data) {
        ApiResult<T> result = message(msg);
        result.setData(data);
        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = message("OK!");
        result.setData(data);
        return result;
    }

    public static <T> ApiResult<T> failure(String msg) {
        return message(500, msg);
    }
}
