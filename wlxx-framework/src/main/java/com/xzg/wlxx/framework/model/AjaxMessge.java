package com.xzg.wlxx.framework.model;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/11/15
 */
public enum AjaxMessge {
    QUERY_SUCCESS(200,"成功！"),
    NULL(000,"");

    private String msg;
    private AjaxMessge(int code,String msg){

    }

}
