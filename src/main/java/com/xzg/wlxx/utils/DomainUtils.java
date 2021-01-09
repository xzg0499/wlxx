package com.xzg.wlxx.utils;

import com.xzg.wlxx.framework.base.BaseDomain;

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
public class DomainUtils {
    public static Map<String,Object> toMap(BaseDomain domain){
        Map<String,Object> map = new HashMap<>();
        Class clzz = domain.getClass();
        Field[] fields = clzz.getDeclaredFields();
        for (Field field : fields){
            try {
                String methodName = "get"+BasicUtils.firstToUpcase(field.getName());
                if(!"getSerialVersionUID".equals(methodName)){
                    Method method = clzz.getDeclaredMethod(methodName);
                    Object val = method.invoke(domain);
                    map.put(field.getName(),val);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    public static BaseDomain toDomain(Map<String,Object> map){
        BaseDomain domain = new BaseDomain();

        for(String propertyName : map.keySet()){
            String methodName = "set" + BasicUtils.firstToUpcase(propertyName);


        }

        return domain;
    }
}
