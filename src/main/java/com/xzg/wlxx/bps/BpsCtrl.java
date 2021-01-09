package com.xzg.wlxx.bps;

import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/11/16
 */
@RestController
public class BpsCtrl extends BaseCtrl {
    @GetMapping("/helloBps")
    @ResponseBody
    public AjaxResult hello(){
        return success("Hello BPS!");
    }
}
