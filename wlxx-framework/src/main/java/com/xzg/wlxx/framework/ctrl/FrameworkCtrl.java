package com.xzg.wlxx.framework.ctrl;

import com.xzg.wlxx.framework.model.BaseCtrl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/4/30
 */

@RestController
public class FrameworkCtrl extends BaseCtrl {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Framework!";
    }
}
