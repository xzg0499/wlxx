package com.xzg.wlxx.common.web.exception;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
