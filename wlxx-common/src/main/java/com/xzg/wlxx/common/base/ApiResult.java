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

    public static <T> ApiResult<T> success(String msg) {
        return ApiResult.<T>builder()
                .code(200)
                .msg(msg)
                .build();
    }

    public static <T> ApiResult<T> success(String msg, T data) {
        ApiResult<T> result = success(msg);
        result.setData(data);
        return result;
    }

    public static <T> ApiResult<T> failure(String msg) {
        return ApiResult.<T>builder()
                .code(500)
                .msg(msg)
                .build();
    }
}
