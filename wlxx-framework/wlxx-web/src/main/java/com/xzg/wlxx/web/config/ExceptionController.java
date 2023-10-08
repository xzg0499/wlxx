package com.xzg.wlxx.web.config;

import com.xzg.wlxx.common.base.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Throwable.class)
    public ApiResult<Throwable> thr(Throwable ex) {
        ex.printStackTrace();
        return ApiResult.exception(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<MethodArgumentNotValidException> notValid(MethodArgumentNotValidException ex) {
        return ApiResult.message(500, ex.getMessage(), null, null);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult<NoHandlerFoundException> notHandler(NoHandlerFoundException ex) {
        // TODO 无法捕获404
        return ApiResult.message(500, ex.getMessage(), null, null);
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ProblemDetail error(NoHandlerFoundException ex) {
//        return ProblemDetail.forStatus(404);
//    }
}
