package com.xzg.wlxx.common.util;

import cn.hutool.core.bean.BeanUtil;
import com.xzg.wlxx.common.base.BasePo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoZG
 */
public class PojoConvertor {

    public static <T extends BasePo<T>> T toPo(Class<T> cls, Object srcBean) {
        T obj = null;
        try {
            obj = cls.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        BeanUtil.copyProperties(srcBean, obj);
        return obj;
    }

    public static <T extends BasePo<T>> List<T> toPo(Class<T> cls, List<?> srcBean) {
        List<T> destBean = new ArrayList<>();
        srcBean.forEach(e -> {
            var obj = toPo(cls, e);
            destBean.add(obj);
        });
        return destBean;
    }
}
