package com.xzg.wlxx.web.handler;

import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import com.xzg.wlxx.core.base.response.RestResult;
import com.xzg.wlxx.core.exception.BusinessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截配置
 *
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public RestResult nullPointerException(NullPointerException ex) {
        ex.printStackTrace();
        return BaseRes.failure(ResultMsgEnum.NULL);
    }

    @ExceptionHandler(BusinessException.class)
    public RestResult businessException(BusinessException ex) {
        ex.printStackTrace();
        return BaseRes.failure(ex);
    }

    @ExceptionHandler(Throwable.class)
    public RestResult throwable(Throwable ex) {
        ex.printStackTrace();
        return BaseRes.failure(ex);
    }

    /**
     * @Validated 校验
     */
    @ExceptionHandler(BindException.class)
    public RestResult bindException(BindException e) {
        StringBuffer msg = new StringBuffer();
        e.getAllErrors().forEach(ex -> {
            // FIXME 换行处理
            if (ex instanceof FieldError) {
                msg.append("【").append(((FieldError) ex).getField()).append("】")
                        .append(ex.getDefaultMessage());
            } else {
                msg.append(ex.getDefaultMessage());
            }
            msg.append(" \n ");
        });
        return BaseRes.failure(msg.toString());
    }
}
