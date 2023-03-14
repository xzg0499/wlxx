package com.xzg.wlxx.web.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xzgan
 * @date 2023/3/8
 */
//@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    public RestResponseEntityExceptionHandler() {
        super();
    }

    //@Override
    //protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
    //    return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    //}

    //@Override
    //protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    //    log.error(ex.getMessage(), ex);
    //    if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
    //        request.setAttribute("javax.servlet.error.exception", ex, 0);
    //    }
    //    return new ResponseEntity<>(BaseRes.failure(ResultMsgEnum.NOT_FOUND), headers, status);
    //}
}

