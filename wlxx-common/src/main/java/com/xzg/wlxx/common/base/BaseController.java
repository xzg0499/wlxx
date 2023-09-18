package com.xzg.wlxx.common.base;

public class BaseController {
    public static <T> ApiResult<T> success(T data) {
        return ApiResult.<T>builder()
                .code(200)
                .msg("OK")
                .data(data)
                .build();
    }

    public static <T extends Throwable> ApiResult<T> ex(Throwable ex) {
        return ApiResult.<T>builder()
                .code(500)
                .msg(ex.getMessage())
                .ex(ex)
                .build();
    }
}
