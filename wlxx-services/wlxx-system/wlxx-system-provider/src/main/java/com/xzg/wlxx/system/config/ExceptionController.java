package com.xzg.wlxx.system.config;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController extends BaseController {

    @ExceptionHandler(Throwable.class)
    public ApiResult<Throwable> thr(Throwable ex) {
        ex.printStackTrace();
        return ex(ex);
    }
}
