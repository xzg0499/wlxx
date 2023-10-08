package com.xzg.wlxx.common.base

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class ApiResult<T>(
    var code: Int? = null,
    var msg: String? = null,
    var data: T? = null,
    var ex: Throwable? = null
) {


    companion object {
        fun <T> message(code: Int?, msg: String?, data: T, ex: Throwable?): ApiResult<T> {
            return ApiResult(code, msg, data, ex)
        }

        @JvmStatic
        fun <T> message(msg: String?): ApiResult<T?> {
            return message(200, msg, null, null)
        }

        @JvmStatic
        fun <T> success(): ApiResult<T?> {
            return message(200, "OK", null, null)
        }

        fun <T> success(data: T): ApiResult<T> {
            return message(200, "OK", data, null)
        }

        fun <T> failure(): ApiResult<T?> {
            return message(500, "ERROR", null, null)
        }

        @JvmStatic
        fun <T> failure(msg: String?): ApiResult<T?> {
            return message(500, msg, null, null)
        }

        @JvmStatic
        fun <T> exception(ex: Throwable): ApiResult<T?> {
            return message(500, ex.message, null, ex)
        }
    }
}
