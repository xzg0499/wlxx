package com.xzg.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/9/15
 */

@RestController
public class LoginController {

    @GetMapping("/login/{username}")
    public String login(@RequestParam(value = "username",required = false)String username){

        return "Login succesed!"+username;
    }
}
