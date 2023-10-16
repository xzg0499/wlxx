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

    @GetMapping("quasar")
    public String quasar() {
        return "/page/quasar";
    }

    @GetMapping("main")
    public String mainPage() {
        return "/page/main";
    }
}