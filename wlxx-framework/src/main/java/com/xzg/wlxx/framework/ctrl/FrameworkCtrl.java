package com.xzg.wlxx.framework.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/4/30
 */

@RestController
public class FrameworkCtrl {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Framework!";
    }
}
