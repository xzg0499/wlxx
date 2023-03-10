package com.xzg.wlxx.core.exception;

import com.xzg.wlxx.core.utils.LogMessageUtils;

/**
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Object... args) {
        super(LogMessageUtils.messageFormat(msg, args));
    }
}
