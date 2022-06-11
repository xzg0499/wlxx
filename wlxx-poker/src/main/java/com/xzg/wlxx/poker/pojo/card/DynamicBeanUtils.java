package com.xzg.wlxx.poker.pojo.card;

import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态为bean添加字段
 * @Author gongl
 * @Create 2022-01-11
 */
public class DynamicBeanUtils {

    private static final Logger logger = LoggerFactory.getLogger(DynamicBeanUtils.class);

    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        //得到原对象的属性
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class<?>> propertyMap = Maps.newHashMap();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        //构建新的对象
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        for (Map.Entry<String, Class<?>> entry : propertyMap.entrySet()) {
            try {
                if (!addProperties.containsKey(entry.getKey())) {//原来的值
                    dynamicBean.setValue(entry.getKey(), propertyUtilsBean.getNestedProperty(dest, entry.getKey()));
                }else {//新增的值
                    dynamicBean.setValue(entry.getKey(), addProperties.get(entry.getKey()));
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return dynamicBean.getTarget();
    }

    private static class DynamicBean {
        /**
         * 目标对象
         */
        private Object target;

        /**
         * 属性集合
         */
        private BeanMap beanMap;

        public DynamicBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
            this.target = generateBean(superclass, propertyMap);
            this.beanMap = BeanMap.create(this.target);
        }


        /**
         * bean 添加属性和值
         *
         * @param property
         * @param value
         */
        public void setValue(String property, Object value) {
            beanMap.put(property, value);
        }

        /**
         * 获取属性值
         *
         * @param property
         * @return
         */
        public Object getValue(String property) {
            return beanMap.get(property);
        }

        /**
         * 获取对象
         *
         * @return
         */
        public Object getTarget() {
            return this.target;
        }


        /**
         * 根据属性生成对象
         *
         * @param superclass
         * @param propertyMap
         * @return
         */
        private Object generateBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
            BeanGenerator generator = new BeanGenerator();
            if (null != superclass) {
                generator.setSuperclass(superclass);
            }
            BeanGenerator.addProperties(generator, propertyMap);
            return generator.create();
        }
    }

    public static void main(String[] args) throws Exception {
        tt();
    }

    public static void t1() throws InvocationTargetException, IllegalAccessException {
        TestBean bean = new TestBean();
        bean.setName("张三");
        Map<String, Object> map = new HashMap<>();
        map.put("age", 29);
        //添加参数age--->29
        Object obj = DynamicBeanUtils.getTarget(bean, map);
        //打印结果
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        for(Method method:declaredMethods){
            if(method.getName().startsWith("get")){
                Object o=method.invoke(obj);
                System.out.println("属性值"+method.getName()+"方法->"+o);
            }
        }
    }

    public static void tt() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("name","xxx");
        map.put("age",22);

        A a = new A();


        BeanGenerator generator = new BeanGenerator();
        generator.setSuperclass(a.getClass());


        Map<String,Class<?>> propertyMap = new HashMap<>();
        propertyMap.put("name",String.class);
        propertyMap.put("age",Integer.class);

        BeanGenerator.addProperties(generator,propertyMap);
        Object obj = generator.create();


        BeanMap beanMap = BeanMap.create(obj);
        beanMap.put("name","xxx");
        beanMap.put("age",22);

        Method[] methods = obj.getClass().getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().startsWith("get")){
                Object o=m.invoke(obj);
                System.out.println("属性值"+m.getName()+"方法->"+o);
            }
        }

        System.out.println();
    }


    @Data
    static class A{
        private String name;

    }

    public static class TestBean{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

