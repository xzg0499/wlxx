package com.xzg.wlxx.poker;

import cn.hutool.core.util.ReUtil;

import java.util.function.UnaryOperator;

/**
 * @author xzgang0499
 * @date 2022-05-05
 * @since jdk1.8
 */
public class Demo2 {

    public static void main(String[] args) throws Exception{

        System.out.println(ReUtil.replaceAll("abc", "(^.)", ((A) s -> s).str("$0-")));

    }

    public interface A {
        String str(String s);
    }

    public abstract class B{

    }
}
