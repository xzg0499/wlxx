package com.xzg.wlxx.user.ctrl;

import com.xzg.wlxx.framework.model.AjaxResult;
import com.xzg.wlxx.framework.ctrl.BaseCtrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/4/30
 */

@RestController
public class UserCtrl extends BaseCtrl {
    @GetMapping("/hello-user")
    public AjaxResult sayHello(){
        return success("Hello User!");
    }
    @GetMapping("/test-error")
    public AjaxResult testError(){
        return error();
    }
}
