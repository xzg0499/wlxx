package com.xzg.wlxx.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author xzgan
 * @date 2023/3/8
 */
//@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseEntityExceptionHandler() {
        super();
    }

    //@Override
    //protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    //    log.error(ex.getMessage(), ex);
    //    if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
    //        request.setAttribute("javax.servlet.error.exception", ex, 0);
    //    }
    //    return new ResponseEntity<>(BaseRes.failure(ResultMsgEnum.NOT_FOUND), headers, status);
    //}
}

