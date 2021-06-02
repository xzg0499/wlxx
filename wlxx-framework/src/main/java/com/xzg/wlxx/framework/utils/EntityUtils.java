package com.xzg.wlxx.framework.utils;

import com.xzg.wlxx.framework.model.BaseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/11/16
 */
public class EntityUtils {
    public static Map<String,Object> toMap(BaseEntity entity){
        Map<String,Object> map = new HashMap<>();
        Class clzz = entity.getClass();
        Field[] fields = clzz.getDeclaredFields();
        for (Field field : fields){
            try {
                String methodName = "get"+BasicUtils.firstToUpcase(field.getName());
                if(!"getSerialVersionUID".equals(methodName)){
                    Method method = clzz.getDeclaredMethod(methodName);
                    Object val = method.invoke(entity);
                    map.put(field.getName(),val);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    public static BaseEntity toEntity(Map<String,Object> map){
        BaseEntity entity = new BaseEntity();
        for(String propertyName : map.keySet()){
            String methodName = "set" + BasicUtils.firstToUpcase(propertyName);
        }
        return entity;
    }
}
