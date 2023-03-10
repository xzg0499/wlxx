package com.xzg.wlxx.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xzgan
 * @date 2023/3/7
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BusinessException {
    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Object... args) {
        super(msg, args);
    }
}
