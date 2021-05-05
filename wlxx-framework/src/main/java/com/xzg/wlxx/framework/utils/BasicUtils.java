package com.xzg.wlxx.framework.utils;

import cn.hutool.core.util.StrUtil;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/11/15
 */
public class BasicUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }
    public static String firstToUpcase(String s){
        String fs = "";
        if(!StrUtil.isBlank(s)){
            if(s.length()==1){
                fs = Character.toUpperCase(s.charAt(0))+"";
            }else{
                fs = Character.toUpperCase(s.charAt(0))+s.substring(1,s.length());
            }
        }
        return fs;
    }
}
