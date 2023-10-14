package com.xzg.wlxx.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XiaoZG
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "/page/index";
    }
}
