package com.xzg.wlxx.framework.ctrl;


import com.xzg.wlxx.framework.model.AjaxResult;
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
    public AjaxResult defaultError(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception{
        return error(e.getMessage());
    }
}
