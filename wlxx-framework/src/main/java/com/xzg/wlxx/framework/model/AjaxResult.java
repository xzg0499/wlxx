package com.xzg.wlxx.framework.model;

import java.util.HashMap;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/4 22:07
 */
public class AjaxResult<K,V> extends HashMap<K,V> {
    private final static int SUCCESS_CODE = 200;
    private final static int ERROR_CODE = 0;

    private final static String SUCCESS_MSG = "success";
    private final static String ERROR_MSG = "error";


    /**
     * 限制外部实例化
     */
    protected AjaxResult(){

    }

    public AjaxResult<String,Object> success(){
        AjaxResult<String,Object> result = new AjaxResult<>();
        result.put("code",SUCCESS_CODE);
        result.put("msg",ERROR_CODE);
        return result;
    }

    public AjaxResult<String,Object> success(V data){
        AjaxResult<String,Object> result = new AjaxResult<>();
        result.put("code",SUCCESS_CODE);
        result.put("data",data);
        return result;
    }

    public AjaxResult<String,Object> error(){
        AjaxResult<String,Object> result = new AjaxResult<>();
        result.put("code", ERROR_CODE);
        result.put("msg",ERROR_MSG);
        return result;
    }

    public AjaxResult<String,Object> error(V msg){
        AjaxResult<String,Object> result = new AjaxResult<>();
        result.put("code",ERROR_CODE);
        result.put("msg",msg);
        return result;
    }
}
