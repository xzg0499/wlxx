package com.xzg.wlxx.core.utils;

import org.slf4j.helpers.MessageFormatter;

/**
 * 日志消息工具
 *
 * @author xzgan
 * @date 2023/3/7
 */
public class LogMessageUtils {

    /**
     * 消息格式化
     */
    public static String messageFormat(String msg, Object... args) {
        return MessageFormatter.arrayFormat(msg, args).getMessage();
    }


}
