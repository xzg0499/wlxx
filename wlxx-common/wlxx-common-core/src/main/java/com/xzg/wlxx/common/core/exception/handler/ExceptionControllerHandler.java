package com.xzg.wlxx.common.core.exception.handler;

import com.xzg.wlxx.common.core.exception.BusinessException;
import com.xzg.wlxx.common.core.response.ResponseData;
import com.xzg.wlxx.common.core.enums.ResponseEnum;
import com.xzg.wlxx.common.core.pojo.entity.BaseController;
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
    public ResponseData exception(NullPointerException ex) {
        return failure(ResponseEnum.NULL);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseData exception(BusinessException ex) {
        return failure(ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseData exception(Exception ex){
        return failure(ex);
    }
}
