package com.xzg.wlxx.common.web.handler;

import com.xzg.wlxx.common.web.exception.BusinessException;
import com.xzg.wlxx.common.web.response.Res;
import com.xzg.wlxx.common.web.enums.ResEnum;
import com.xzg.wlxx.common.web.base.BaseController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@RestControllerAdvice
public class ExceptionControllerHandler extends BaseController {

    @ExceptionHandler(NullPointerException.class)
    public Res exception(NullPointerException ex) {
        ex.printStackTrace();
        return failure(ResEnum.NULL);
    }

    @ExceptionHandler(BusinessException.class)
    public Res exception(BusinessException ex) {
        ex.printStackTrace();
        return failure(ex);
    }

    @ExceptionHandler(Exception.class)
    public Res exception(Exception ex) {
        ex.printStackTrace();
        return failure(ex);
    }
}
