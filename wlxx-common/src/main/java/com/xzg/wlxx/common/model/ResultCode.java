package com.xzg.wlxx.common.model;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/3
 */
public enum ResultCode{
    NULL(0,"空值异常"),

    SUCCESS(20000,"成功"),
    ERROR(10000,"失败");

    private Integer code;
    private String msg;

    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
