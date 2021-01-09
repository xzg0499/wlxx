package com.xzg.wlxx.auth.ctrl;


import com.xzg.wlxx.utils.BasicUtils;
import com.xzg.wlxx.auth.domain.TUser;
import com.xzg.wlxx.auth.service.ITUserService;
import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxMessge;
import com.xzg.wlxx.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-11-15
 */
@RestController
public class TUserCtrl extends BaseCtrl {
    @Autowired
    private ITUserService itUserService;

    @PostMapping("/register")
    public AjaxResult addUser(TUser user){
        user.setId(BasicUtils.getUUID());
        itUserService.addUser(user);
        return success();
    }

    @PostMapping("/delete")
    public AjaxResult delUser(String id){
        itUserService.delUser(id);
        return success();
    }

    @PostMapping("/modify")
    public AjaxResult updateUser(TUser user){
        itUserService.updateUser(user);
        return success();
    }

    @PostMapping("/query")
    public AjaxResult queryUser(TUser user){
        return success(AjaxMessge.QUERY_SUCCESS.toString(),itUserService.queryUser(user));
    }

}
