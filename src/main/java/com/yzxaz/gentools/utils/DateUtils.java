package com.yzxaz.gentools.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return 2019-08-27 14:12:40
     */
    public static String getCurrentTime() {
        Date date = new Date();
        return format.format(date);
    }
}
