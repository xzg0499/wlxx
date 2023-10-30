package com.xzg.wlxx.system.sync;

import cn.hutool.core.util.StrUtil;

import java.util.stream.IntStream;

/**
 * @author XiaoZG
 */
public class TestSync {

    private static volatile int count = 0;

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i ->
                new Thread(TestSync::countAdd)
                        .start()
        );
    }

    public synchronized static void countAdd() {
        // synchronized 能够保证count顺序累加输出
        count++;
        System.out.println(StrUtil.format("thread {} result {}", Thread.currentThread().getName(), count));
    }

}
