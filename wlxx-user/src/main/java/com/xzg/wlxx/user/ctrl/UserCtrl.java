package com.xzg.wlxx.user.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/4/30
 */

@RestController
public class UserCtrl {
    @GetMapping("/hellp-user")
    public String sayHello(){
        return "Hello User!";
    }
}
