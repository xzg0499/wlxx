package com.xzg.wlxx.framework.utils;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/19
 */
public class ClassUtils {
    /**
     * 获取obj及obj父类中所以的属性
     * @param obj
     * @return
     */
    public static List<XField> getFileds(Object obj){
        List<XField> fieldList = new ArrayList<>();
        Class<?> clzz = obj.getClass();
        Field[] fields;
        do {
            fields = clzz.getDeclaredFields();
            for(Field f : fields){
                XField xf = new XField();
                xf.setClzz(clzz);
                xf.setName(f.getName());
                xf.setMethodName(getMethodName(f.getName()));
                xf.setType(f.getType());//TODO 用于判断反射字段的类型
                fieldList.add(xf);
            }
            //TODO 是否要剔除interface？
            clzz = clzz.getSuperclass();
        }while (clzz!=null);
        return fieldList;
    }

    public static String getMethodName(String key){
        if(StrUtil.isBlankIfStr(key)){
            return key;
        }else if(key.length()==1){
            return key.toUpperCase();
        }else {
            return key.substring(0,1).toUpperCase()+key.substring(1);
        }
    }
    @Data
    public static class XField {
        private String name;
        private Class<?> clzz;
        private String methodName;
        private Class<?> type;
    }
}


