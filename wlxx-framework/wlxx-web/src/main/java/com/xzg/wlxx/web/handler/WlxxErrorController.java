package com.xzg.wlxx.web.handler;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;

import javax.validation.constraints.NotNull;

/**
 * @author xzgan
 * @date 2023/3/8
 */
//@Controller
//@RequestMapping("/wlxx/error")
public class WlxxErrorController extends BasicErrorController {


    public WlxxErrorController(@NotNull ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }


}
