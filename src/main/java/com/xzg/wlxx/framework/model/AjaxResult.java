package com.xzg.wlxx.framework.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/4 22:07
 */
public class AjaxResult extends HashMap {
    /**
     * 针对特殊状态自定义消息返回
     * @param code
     * @param msg
     * @return
     */
    public AjaxResult message(int code,String msg){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code",code);
        ajaxResult.put("msg",msg);
        return ajaxResult;
    }
    /**
     * 成功调用返回
     * @return
     */
    public AjaxResult success(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", 1);
        ajaxResult.put("msg", "成功！");
        return ajaxResult;
    }
    public AjaxResult success(String msg){
        AjaxResult ajaxResult = success();
        ajaxResult.put("msg" ,msg);
        return ajaxResult;
    }
    public AjaxResult success(String msg,Object data){
        AjaxResult ajaxResult = success(msg);
        ajaxResult.put("data", data);
        return ajaxResult;
    }
    public AjaxResult success(String msg,Object list,int total){
        AjaxResult ajaxResult = success(msg);
        Map<String,Object> data = new HashMap<>();
        data.put("list", list);
        data.put("total", total);
        ajaxResult.put("data", data);
        return ajaxResult;
    }

    /**
     * 失败调用返回
     * @return
     */
    public AjaxResult error(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", 0);
        ajaxResult.put("msg", "失败！");
        return ajaxResult;
    }
    public AjaxResult error(String msg){
        AjaxResult ajaxResult = error();
        ajaxResult.put("msg", msg);
        return ajaxResult;
    }
    public AjaxResult error(Exception e){
        AjaxResult ajaxResult = error();
        ajaxResult.put("e",e);
        return ajaxResult;
    }
}
