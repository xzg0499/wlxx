package com.xzg.wlxx.common.util;

import cn.hutool.core.collection.CollUtil;
import com.xzg.wlxx.common.base.BasePo;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * @author XiaoZG
 */
public class IteratorUtils {


    /**
     * 迭代器
     */
    public static <V, P extends BasePo<P>> void iterator(List<V> result, List<P> list
            , BiPredicate<V, P> biPredicate
            , Function<P, V> function
            , BiConsumer<V, List<V>> consumer) {
        result.forEach(e -> {
            var children = list.stream()
                    .filter(l -> biPredicate.test(e, l))
                    .map(function).toList();
            if (CollUtil.isNotEmpty(children)) {
                iterator(children, list, biPredicate, function, consumer);
            }
            consumer.accept(e, children);
        });
    }
}
