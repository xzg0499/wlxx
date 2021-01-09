package com.xzg.wlxx.bps.ctrl;

import com.xzg.wlxx.framework.base.BaseCtrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/11/17
 */
@RestController
public class BPSPageCtrl extends BaseCtrl {

    @GetMapping("/editor")
    public String toModeler() {
        return "/modeler";
    }
}
