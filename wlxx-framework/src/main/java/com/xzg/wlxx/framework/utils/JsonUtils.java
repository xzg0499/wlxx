package com.xzg.wlxx.framework.utils;

import com.xzg.wlxx.framework.model.BaseEntity;
import com.xzg.wlxx.framework.utils.serialization.json.JsonStrategy;
import com.xzg.wlxx.framework.utils.serialization.json.JsonStrategyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * TODO 由于大量应用的反射特性，在大量字段对象时可能会导致执行缓慢降低代码效率，并且可能存在反射的未知风险，建议尽量在业务代码中避免使用
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/9
 */
public class JsonUtils {
    //TODO 运用策略模式设计一个json序列化工具

    public static String toJson(Object obj){
        return toJson(JsonStrategyEnum.NAME_UP,obj);
    }
    public static String toJson(JsonStrategyEnum jsonStrategyEnum,Object obj){
        StringBuffer json = new StringBuffer("{");
        JsonStrategy strategy = jsonStrategyEnum.getStrategy();

        List<ClassUtils.XField> fields = ClassUtils.getFileds(obj);
        Method method;
        for(ClassUtils.XField f : fields){
            try {
                method = f.getClzz().getDeclaredMethod("get"+ClassUtils.getMethodName(f.getName()));
                Object val = method.invoke(obj);
                if(strategy.isNull() && null == val){
                    val = "";
                }
                json.append("\""+strategy.getName(f.getName())+"\":\""+val+"\",");
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
                //TODO 是否能够判断method是否存在当前clzz中，如果没有则不继续执行
            }
        }
        return json.toString().replaceAll(".$","")+"}";
    }
}
