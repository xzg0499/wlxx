package com.xzg.wlxx.common.base;

public class BaseController {
    public static <T> ApiResult<T> success(T data) {
        return ApiResult.success(data);
    }

    public static <T extends Throwable> ApiResult<T> ex(Throwable ex) {
        return ApiResult.<T>builder()
                .code(500)
                .msg(ex.getMessage())
                .ex(ex)
                .build();
    }
}
