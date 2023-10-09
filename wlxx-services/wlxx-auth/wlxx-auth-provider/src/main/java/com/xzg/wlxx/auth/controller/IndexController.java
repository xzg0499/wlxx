package com.xzg.wlxx.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XiaoZG
 */
@Controller
//@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "/page/index";
    }
}
