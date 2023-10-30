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

    public static <T> ApiResult<T> message(Integer code, String msg, T data, Throwable ex) {
        return ApiResult.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .ex(ex)
                .build();
    }

    public static <T> ApiResult<T> message(String msg) {
        return message(200, msg, null, null);
    }

    public static <T> ApiResult<T> message(boolean isSuccess) {
        return isSuccess ? success() : failure();
    }

    public static <T> ApiResult<T> success() {
        return message(200, "OK", null, null);
    }

    public static <T> ApiResult<T> success(T data) {
        return message(200, "OK", data, null);
    }

    public static <T> ApiResult<T> failure() {
        return message(500, "ERROR", null, null);
    }

    public static <T> ApiResult<T> failure(String msg) {
        return message(500, msg, null, null);
    }

    public static <T> ApiResult<T> exception(Throwable ex) {
        return message(500, ex.getMessage(), null, ex);
    }
}
