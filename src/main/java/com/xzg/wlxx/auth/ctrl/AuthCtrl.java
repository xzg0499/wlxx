package com.xzg.wlxx.auth.ctrl;

import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthCtrl extends BaseCtrl {
    @GetMapping("/helloAuth")
    @ResponseBody
    public AjaxResult hello(){
        log.info("into auth hello method");
        return success("Hello Auth!");
    }
}
