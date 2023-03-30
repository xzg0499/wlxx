package com.xzg.wlxx.system.client.entity.vo;

import cn.hutool.json.JSONUtil;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xzgan
 * @date 2023/3/28
 */
//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoBaseVo<P extends BasePo<P>> /*extends HashMap<String, Object> implements Map<String, Object>*/ {

    private String name;

    public Field[] getField() {
        Class<?> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        Type type = cls.getGenericSuperclass();
        Field[] poFields = getParentFields(type);
        return fields;
    }


    public Field[] getParentFields(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            Type argument = typeArguments[0];
            if (argument instanceof Class<?>) {
                Field[] poFields = ((Class<?>) argument).getDeclaredFields();
                return poFields;
            }
        }
        return new Field[0];
    }


    public static void main(String[] args) {
        DictSeqVo dictSeqVo = new DictSeqVo();
        dictSeqVo.getField();
        Enhancer e = new Enhancer();
        e.setSuperclass(dictSeqVo.getClass());
        //e.setStrategy(new DefaultGeneratorStrategy() {
        //    protected ClassGenerator transform(ClassGenerator cg) {
        //        return new TransformingClassGenerator(cg,
        //                new AddPropertyTransformer(new String[]{"foo"},
        //                        new org.springframework.asm.Type[]{org.springframework.asm.Type.getType(Integer.TYPE)})
        //        );
        //    }
        //});
        e.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                // TODO Auto-generated method stub
                return "FixedValue";
            }
        });
        //设置类加载器
        e.setClassLoader(dictSeqVo.getClass().getClassLoader());
        Object obj = e.create();
        System.out.println(JSONUtil.toJsonStr(obj));
    }

}
