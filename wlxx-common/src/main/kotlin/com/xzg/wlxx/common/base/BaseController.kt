package com.xzg.wlxx.common.base

open class BaseController {

    companion object {
        fun <T> success(t: T): ApiResult<T> {
            return ApiResult(20, "OK", t)
        }
    }
}