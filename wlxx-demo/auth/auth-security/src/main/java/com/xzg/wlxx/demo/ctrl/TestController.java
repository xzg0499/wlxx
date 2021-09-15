package com.xzg.demo.ctrl;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/9/15
 */

@RestController
public class TestController {


    @GetMapping("/admin")
    public String admin(@RequestParam(value = "username",required = false)String username){
        return "Hello Admin:"+username;
    }

    @GetMapping("/guest")
    public String guest(@RequestParam(value = "username",required = false)String username){
        return "Hello Guest:"+username;
    }
}
