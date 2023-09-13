package com.xzg.wlxx.system.config

import com.xzg.wlxx.system.base.ApiResult
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionController {

    @ExceptionHandler(value = [Throwable::class])
    fun throwable(e: Throwable): ApiResult<Throwable> {
        e.printStackTrace()
        return ApiResult(500, e.message, null, e)
    }
}