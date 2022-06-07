package com.xzg.wlxx.common.core.handler;

import com.xzg.wlxx.common.core.exception.BusinessException;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.common.core.enums.ResEnum;
import com.xzg.wlxx.common.core.base.BaseController;
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
        return failure(ResEnum.NULL);
    }

    @ExceptionHandler(BusinessException.class)
    public Res exception(BusinessException ex) {
        return failure(ex);
    }

    @ExceptionHandler(Exception.class)
    public Res exception(Exception ex){
        return failure(ex);
    }
}
