package com.xzg.wlxx.common.ctrl;


import com.xzg.wlxx.common.model.CtrlResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/5 22:00
 */
@ControllerAdvice
public class ExceptionCtrl extends BaseCtrl {
    /**
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CtrlResult defaultError(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception{
        return failure(e.getMessage());
    }
}