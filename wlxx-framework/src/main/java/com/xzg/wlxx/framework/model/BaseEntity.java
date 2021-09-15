package com.xzg.wlxx.framework.model;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xzg.wlxx.framework.utils.ClassUtils;
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
    private Serializable id;

    public Serializable getId(){
        return this.id;
    }

    public void setId(Serializable id){
        this.id = id;
    }
    /**
     * 配置mybatis-plus activeRecord模式
     * @return Serializable
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * 定义一个统一的set方法
     * @param key
     * @param val
     */
    public void set(String key,Object val){
        try {
            String methodName = "set"+key.substring(0,1).toUpperCase()+key.substring(1);
            Method method = this.getClass().getMethod(methodName,val.getClass());
            method.invoke(this,val);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 定义一个统一的get方法
     * @param key
     * @return
     */
    public Object get(String key){
        Object val = null;
        try {
            String methodName = "get"+ClassUtils.getMethodName(key);
            Method method = this.getClass().getMethod(methodName);
            val = method.invoke(this);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * 重写toString方法，方便改写
     * @return
     */
    @Override
    public String toString(){
        //TODO 重写toString
        StringBuffer str = new StringBuffer("{");
        Field[] fields = this.getClass().getFields();
        for(Field field : fields){
            try {
                Method method = this.getClass().getMethod("get"+ ClassUtils.getMethodName(field.getName()));
                Object val = method.invoke(this);
                if(BaseEntity.class.isAssignableFrom(val.getClass())){
                    val = val.toString();
                }
                str.append("\""+field.getName()+"\":\""+val+"\",");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        str.replace(str.length()-1,str.length(),"").append("}");
        return str.toString();
    }
}
