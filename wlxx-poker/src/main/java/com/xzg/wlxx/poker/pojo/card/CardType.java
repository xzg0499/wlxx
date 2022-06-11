package com.xzg.wlxx.poker.pojo.card;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xzg.wlxx.poker.pojo.Card;
import lombok.Data;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xzgan
 * @date 2022/6/10
 * @since jdk1.8
 */
@Data
public class CardType {

    public static final BeanGenerator generator = new BeanGenerator();

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        CardType cardType = CardType.newInstance(
                new Card("1","h"),
                new Card("1","h"),
                new Card("1","m"),
                new Card("1","f")
            );
        Field[] fields = cardType.getClass().getDeclaredFields();;
        Arrays.stream(fields).forEach(e->{
            System.out.println(e.getName());
        });
        System.out.println(cardType.get("card1"));
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public Object get(String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = this.getClass().getDeclaredMethod("get"+ Character.toUpperCase(name.charAt(0)) +StrUtil.toUnderlineCase(name.replaceAll("^.","")));
        Object obj = method.invoke(this);
        return obj;
    }

    public static CardType newInstance(Card ... card){
        generator.setSuperclass(CardType.class);
        Map<String,Class<?>> propertyMap = getPropertyMap(card);
        BeanGenerator.addProperties(generator,propertyMap);
        Object obj = generator.create();
        getBeanMap(obj,card);
        if(obj instanceof CardType){
            return (CardType) obj;
        }
        return null;
    }

    public static Map<String,Class<?>> getPropertyMap(Card ... card){
        Map<String,Class<?>> propertyMap = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(card).forEach(e->{
            propertyMap.put("card"+index.get(),Card.class);
            index.addAndGet(1);
        });
        return propertyMap;
    }

    public static BeanMap getBeanMap(Object obj,Card ... card){
        BeanMap beanMap = BeanMap.create(obj);
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(card).forEach(e->{
            beanMap.put("card"+index.get(),e);
            index.addAndGet(1);
        });
        return beanMap;
    }
}
