package com.xzg.wlxx.framework.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/5/5
 */
public class BaseEntity<T extends Model<?>> extends Model<T> {

    @TableId("id")
    private String id;

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id=id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public void set(String key,Object val){
        try {
            String methodName = "set"+key.substring(0,1).toUpperCase()+key.substring(1);
            Method method = this.getClass().getMethod(methodName,val.getClass());
            method.invoke(this,val);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public Object get(String key){
        Object val = null;
        try {
            String methodName = "get"+getMethodName(key);
            Method method = this.getClass().getMethod(methodName);
            val = method.invoke(this);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return val;
    }

    @Override
    public String toString(){
        //TODO 重写toString
        StringBuffer str = new StringBuffer("{");
        Field[] fields = this.getClass().getFields();
        for(Field field : fields){
            try {
                Method method = this.getClass().getMethod("get"+getMethodName(field.getName()));
                Object val = method.invoke(this);
                str.append("\""+field.getName()+"\":\""+val+"\",");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        str.replace(str.length()-1,str.length(),"").append("}");
        return str.toString();
//        return super.toString();
    }

    // FIXME String类型空值判断
    private static String getMethodName(String key){
        if(key==null || key.length()==0){
            return key;
        }else if(key.length()==1){
            return key.toUpperCase();
        }else {
            return key.substring(0,1).toUpperCase()+key.substring(1);
        }
    }
}
