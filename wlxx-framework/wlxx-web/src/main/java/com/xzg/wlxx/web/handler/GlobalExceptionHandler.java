package com.xzg.wlxx.web.handler;

import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.enums.ResultMsgEnum;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
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
@Slf4j
public class GlobalExceptionHandler {

    //@ExceptionHandler(NullPointerException.class)
    //public RestResult nullPointerException(NullPointerException ex) {
    //    ex.printStackTrace();
    //    return BaseRes.failure(ResultMsgEnum.NULL);
    //}
    //
    //@ExceptionHandler(BusinessException.class)
    //public RestResult businessException(BusinessException ex) {
    //    ex.printStackTrace();
    //    return BaseRes.failure(ex);
    //}

    // TODO 不能直接对Exception捕获
    //@ExceptionHandler(Throwable.class)
    //public RestResult throwable(Throwable ex) {
    //    ex.printStackTrace();
    //    return BaseRes.failure(ex);
    //}

    @ExceptionHandler(Exception.class)
    public RestApiResult businessException(Exception ex) {
        ex.printStackTrace();
        // 默认失败返回
        RestApiResult result = ApiResult.failure();
        if (ex instanceof BusinessException) {
            result = ApiResult.failure(ex.getMessage());
        } else if (ex instanceof NullPointerException) {
            result = ApiResult.failure(ResultMsgEnum.NULL);
        } else if (ex instanceof DuplicateKeyException) {
            result = ApiResult.failure(ResultMsgEnum.DB_DUPLICATE_KEY);
        }
        return result;
    }

    /**
     * @Validated 校验
     */
    @ExceptionHandler(BindException.class)
    public RestApiResult bindException(BindException e) {
        StringBuffer msg = new StringBuffer();
        e.getAllErrors().forEach(ex -> {
            // FIXME 换行处理
            if (ex instanceof FieldError) {
                msg.append("【").append(((FieldError) ex).getField()).append("】")
                        .append(ex.getDefaultMessage());
            } else {
                msg.append(ex.getDefaultMessage());
            }
            msg.append("\r\n");
        });
        return ApiResult.failure(msg.toString());
    }

    //@NotNull
    //@Override
    //protected ResponseEntity<Object> handleExceptionInternal(@NotNull Exception ex, Object body, @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request) {
    //    return super.handleExceptionInternal(ex, BaseRes.failure(ResultMsgEnum.NOT_FOUND), headers, status, request);
    //}
}
