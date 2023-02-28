package com.xzg.wlxx.system.util;

import cn.hutool.core.util.StrUtil;

import java.util.function.Consumer;

/**
 * If判断工具，减少If语句
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.system.util
 * @date 2022/12/25 11:22
 */
public class IfUtils {

    public interface IfHandler {
        void handler(Runnable ifTrue, Runnable ifFalse);
    }

    public interface IfTrueHandler {
        void ifTrue(Runnable ifTrue);
    }

    public interface PresentOrElseHandler<T extends Object> {
        void presentOrElseHandler(Consumer<? super T> consumer, Runnable action);
    }

    public static IfHandler ifHandler(boolean bool) {
        return (ifTrue, ifFalse) -> {
            if (bool) {
                ifTrue.run();
            } else {
                ifFalse.run();
            }
        };
    }

    public static IfTrueHandler ifTrue(boolean bool) {
        return (ifTrue) -> {
            if (bool) {
                ifTrue.run();
            }
        };
    }

    public static PresentOrElseHandler<?> ifTrue(Object str) {
        return ((consumer, action) -> {
            if (StrUtil.isBlankIfStr(str)) {
                action.run();
            } else {
                consumer.accept(str);
            }
        });
    }
}
