package com.xzg.wlxx.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/4 22:07
 */

public class CtrlResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T result;

    /**
     * 保护class不被随意创建
     */
    protected CtrlResult(){

    }

    /**
     * 接口请求失败
     * @param msg
     * @return
     */
    public CtrlResult<T> failure(String msg){
        CtrlResult<T> result = new CtrlResult<>();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 接口请求成功
     * @param data
     * @return
     */
    public CtrlResult<T> success(T data){
        CtrlResult<T> result = new CtrlResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setResult(data);
        return result;
    }

    // 附带给出消息提示
    public CtrlResult<T> success(String msg,T data){
        CtrlResult<T> result = new CtrlResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(msg);
        result.setResult(data);
        return result;
    }

    /**
     * 通用消息接口
     * @param code
     * @return
     */
    public CtrlResult<T> msg(ResultCode code){
        CtrlResult<T> result = new CtrlResult<>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    /**
     * Get/Set
     * @return
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
