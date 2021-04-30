package com.xzg.wlxx.auth.ctrl;


import com.xzg.wlxx.auth.service.ITMenuService;
import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-06
 */
@RestController
public class TMenuCtrl extends BaseCtrl {
    @Autowired
    private ITMenuService itMenuService;

    @GetMapping("/selectAuth")
    @ResponseBody
    public AjaxResult select(){
        return success("查询成功",itMenuService.select());
    }
}
