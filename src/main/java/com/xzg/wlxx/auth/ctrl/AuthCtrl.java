package com.xzg.wlxx.auth.ctrl;

import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCtrl extends BaseCtrl {
    @GetMapping("/helloAuth")
    @ResponseBody
    public AjaxResult hello(){
        return success("Hello Auth!");
    }
}
