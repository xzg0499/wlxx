package com.xzg.wlxx.web.config

import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.ApiResult.Companion.exception
import com.xzg.wlxx.common.base.ApiResult.Companion.message
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ExceptionController {
    @ExceptionHandler(Throwable::class)
    fun thr(ex: Throwable): ApiResult<Throwable?> {
        ex.printStackTrace()
        return exception(ex)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun notValid(ex: MethodArgumentNotValidException): ApiResult<MethodArgumentNotValidException?> {
        return message(500, ex.message, null, null)
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notHandler(ex: NoHandlerFoundException): ApiResult<NoHandlerFoundException?> {
        // TODO 无法捕获404
        return message(500, ex.message, null, null)
    } //    @ExceptionHandler(NoHandlerFoundException.class)
    //    public ProblemDetail error(NoHandlerFoundException ex) {
    //        return ProblemDetail.forStatus(404);
    //    }
}
