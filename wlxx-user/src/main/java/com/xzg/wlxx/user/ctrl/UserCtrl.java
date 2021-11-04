package com.xzg.wlxx.user.ctrl;


import com.xzg.wlxx.common.ctrl.BaseCtrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 肖志刚
 * @Date: 2021/11/4 17:15
 */
@RestController
public class UserCtrl extends BaseCtrl {
    @GetMapping("/hello-user")
    public String hello(){
        return "Hello User!";
    }
}
