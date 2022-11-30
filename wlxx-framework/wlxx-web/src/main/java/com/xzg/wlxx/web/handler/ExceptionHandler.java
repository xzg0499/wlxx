package com.xzg.wlxx.web.handler;

import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import com.xzg.wlxx.core.base.response.Result;
import com.xzg.wlxx.core.exception.BusinessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截配置
 *
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */

@RestControllerAdvice
public class ExceptionHandler extends BaseController {

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public Result exception(NullPointerException ex) {
        ex.printStackTrace();
        return BaseRes.failure(ResultMsgEnum.NULL);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public Result exception(BusinessException ex) {
        ex.printStackTrace();
        return BaseRes.failure(ex);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result exception(Exception ex) {
        ex.printStackTrace();
        return BaseRes.failure(ex);
    }

    /**
     * @Validated 校验
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    public Result validatedBindException(BindException e) {
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
