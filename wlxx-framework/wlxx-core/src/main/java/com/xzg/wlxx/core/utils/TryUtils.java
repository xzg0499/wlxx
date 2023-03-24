package com.xzg.wlxx.core.utils;

import java.util.function.Supplier;

/**
 * 语法糖 Try
 *
 * @author xzgan
 * @date 2023/3/20
 */
public class TryUtils {

    public static <T> T run(Supplier<T> supplier) {
        supplier.get();
        return null;
    }
}
