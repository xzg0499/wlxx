package com.xzg.wlxx.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 日期/时间-格式转换
 *
 * @author xzgan
 * @date 2023/3/3
 */
public class DateTimeConvertor {

    private final static ZoneOffset zoneOffset = ZoneOffset.UTC;

    public static long nowTime2EpochMilli() {
        return LocalDateTime.now().toInstant(zoneOffset)
                .toEpochMilli();
    }

    public static long nowDate2EpochMilli() {
        return LocalDate.now().atStartOfDay()
                .toInstant(zoneOffset).toEpochMilli();
    }

    public static LocalDateTime timestamp2Time(long timestamp) {
        return LocalDateTime
                .ofEpochSecond(timestamp / 1000, 0, zoneOffset);
    }

    public static LocalDate timestamp2Date(long timestamp) {
        return LocalDate.ofEpochDay(timestamp / 1000);
    }
}
