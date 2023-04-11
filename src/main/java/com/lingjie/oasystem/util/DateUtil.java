package com.lingjie.oasystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    public static final String FORMAT_DEFAULT = "yyyy-MM-dd";

    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";

    public static final String FORMAT_YYYYMMDDHH = "yyyyMMddHH";

    public static final String FORMAT_YYYYMMDDHHMI = "yyyyMMddHHmm";

    public static final String FORMAT_YYYYMM = "yyyyMM";

    public static final String FORMAT_HHMISS = "HH:mm:ss";

    public static final String FORMAT_YYYYMMDDHHMISS = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_YYYYMMDDHHMISS_2 = "yyyy/MM/dd HH:mm:ss";

    public static final String FORMAT_YYMMDDHHMISS = "yyMMddHHmmss";

    public static final String FORMAT_YYYYMMDDHHMISS_14 = "yyyyMMddHHmmss";

    public static final String FORMAT_YYMMDD = "yyMMdd";

    public static final String FORMAT_YYYY = "yyyy";

    public static final String FORMAT_YY = "yy";

    public static final String FORMAT_MM = "MM";

    public static final String FORMAT_DD = "dd";

    public static final String FORMAT_HH = "HH";

    public static final String FORMAT_MI = "mm";

    public static final String FORMAT_SS = "ss";

    public static final String FORMAT_E = "E";

    private static final String DEFAULT_ERROR_CODE = "9999";

    /**
     * 获取当前系统日期
     *
     * @return Date 当前系统日期
     */
    public static Date now() {

        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前系统日期
     *
     * @param pattern 日期格式描述
     * @return String 当前系统日期
     */
    public static String getCurrentDateAsString(String pattern) {

        return format(Calendar.getInstance().getTime(), pattern);
    }

    /**
     * 获取指定日期字符串的年信息
     *
     * @param text 日期字符串
     * @return 年信息
     */
    public static String getYear(String text) {

        return getYear(text, FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期字符串的年信息
     *
     * @param text 日期字符串
     * @param pattern 日期格式描述
     * @return 年信息
     */
    public static String getYear(String text, String pattern) {

        return format(parseDate(text, pattern), FORMAT_YYYY);
    }

    /**
     * 获取指定日期字符串的月信息
     *
     * @param text 日期字符串
     * @return 月信息
     */
    public static String getMonth(String text) {

        return getMonth(text, FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期字符串的月信息
     *
     * @param text 日期字符串
     * @param pattern 日期格式描述
     * @return 月信息
     */
    public static String getMonth(String text, String pattern) {

        return format(parseDate(text, pattern), FORMAT_MM);
    }

    /**
     * 获取指定日期字符串的日信息
     *
     * @param text 日期字符串
     * @return 日信息
     */
    public static String getDay(String text) {

        return getDay(text, FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期字符串的日信息
     *
     * @param text 日期字符串
     * @param pattern 日期格式描述
     * @return 日信息
     */
    public static String getDay(String text, String pattern) {

        return format(parseDate(text, pattern), FORMAT_DD);
    }

    /**
     * 获取指定日期字符串的星期信息
     *
     * @param text 日期字符串
     * @return 星期信息
     */
    public static String getWeekDay(String text) {

        return getWeekDay(text, FORMAT_DEFAULT);
    }

    /**
     * 获取指定日期字符串的星期信息
     *
     * @param text 日期字符串
     * @param pattern 日期格式描述
     * @return 星期信息
     */
    public static String getWeekDay(String text, String pattern) {

        return format(parseDate(text, pattern), FORMAT_E);
    }

    public static boolean checkHHmmss(String hhmmss) {
        if (Validator.isNullOrEmpty(hhmmss)) {
            return  true;
        }
        if (hhmmss.length() != 8) {
            return false;
        }
        final String[] split = hhmmss.split(":");
        if (split.length != 3) {
            return false;
        }
        if (Integer.parseInt(split[0]) > 23 || Integer.parseInt(split[0]) < 0) {
            return false;
        }
        if (Integer.parseInt(split[1]) > 59 || Integer.parseInt(split[1]) < 0) {
            return false;
        }
        if (Integer.parseInt(split[2]) > 59 || Integer.parseInt(split[2]) < 0) {
            return false;
        }
        return true;
    }

    /**
     * String类型转换成Date
     *
     * @param text String型日期
     * @param pattern 格式要求
     * @return 日期文字描述
     * @author zejun.dong
     */
    public static Date parseDate(String text, String pattern) {

        if (StringUtil.isEmpty(text)) {
            return null;
        }
        DateFormat formatter = getDateFormat(pattern);
        try {
            return formatter.parse(text);
        } catch (ParseException e) {
            throw new NullPointerException();
        }
    }

    /**
     * 验证指定的String类型的日期是否合法
     *
     * @param text String型日期
     * @param pattern 格式要求
     * @return 合法返回true, 否则返回false
     * @author zejun.dong
     */
    public static boolean validate(String text, String pattern) {

        if (StringUtil.isEmpty(text)) {
            return false;
        }
        DateFormat formatter = getDateFormat(pattern);
        try {
            formatter.parse(text);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Date类型转换成String
     *
     * @param date Date型日期
     * @param pattern 格式要求
     * @return 日期文字描述
     * @author zejun.dong
     */
    public static String format(Date date, String pattern) {

        if (date == null) {
            return null;
        }
        DateFormat formatter = getDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * Calendar类型转换成String
     *
     * @param date Calendar型日期
     * @param pattern 格式要求
     * @return 日期文字描述
     * @author zejun.dong
     */
    public static String format(Calendar date, String pattern) {

        return format(date.getTime(), pattern);
    }

    /*
     * 获取正确的DateFormat对象
     *
     * @author zejun.dong
     */
    private static DateFormat getDateFormat(String pattern) {

        DateFormat df = new SimpleDateFormat(pattern);
        df.setTimeZone(TimeZone.getDefault());
        return df;
    }

    /**
     * 当前日期加减天
     *
     * @param days
     * @return
     * @author zejun.dong
     */
    public static Date addDay(int days) {

        Calendar strDate = Calendar.getInstance();
        strDate.add(Calendar.DATE, days);//如果不够减会将月变动
        return strDate.getTime();
    }

    /**
     * 当前日期加减月
     *
     * @param months
     * @return
     * @author zejun.dong
     */
    public static Date addMonth(int months) {

        Calendar strDate = Calendar.getInstance();
        strDate.add(Calendar.MONTH, months);//如果不够减会将月变动
        return strDate.getTime();
    }

    /**
     *
     * 指定日期加减填
     *
     * @param date
     * @param field
     * @param amount
     * @return
     * @author zejun.dong
     */
    public static Date addDay(Date date, int days) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 根据传入的日期加减月
     *
     * @param date
     * @param months
     * @return
     * @author zejun.dong
     */
    public static Date addMonth(Date date, int months) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期的最晚时间
     *
     * @param date 指定日期
     * @return 指定日期的最晚时间
     * @author dongzejun
     */
    public static Date getEndOfDay(Date date) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 000);
        return c.getTime();
    }

    /**
     * 获取指定日期的最早时间
     *
     * @param date 指定日期
     * @return 指定日期的最早时间
     * @author zejun.dong
     */
    public static Date getStartOfDay(Date date) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * Test function
     */
    public static void main(String[] args) {

        System.out.println(DateUtil.getStartOfDay(new Date()));
    }

    /**
     * 获取指定日期的当年最后一天的日期
     *
     * @param date 指定日期
     * @return 获取指定日期的当年最后一天的日期
     * @author zejun.dong
     */
    public static Date getEndOfYear(Date date) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DAY_OF_MONTH, 31);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期月份的第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfMonth(Date date) {

        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        Date first = c.getTime();
        return getStartOfDay(first);
    }

    /**
     * 传入一个日期和今天相比较
     * 比今天早返回-1
     * 等于今天返回0
     * 比今天晚返回1
     *
     * @param date
     * @return
     * @author zejun.dong
     */
    public static String compareDateWithToday(Date date) {

        if (date == null) {
            return null;
        }
        Date today = new Date();
        today = DateUtil.getStartOfDay(today);

        date = DateUtil.getStartOfDay(date);
        if (date.getTime() > today.getTime()) {
            return "1";
        } else if (date.getTime() == today.getTime()) {
            return "0";
        } else if (date.getTime() < today.getTime()) {
            return "-1";
        }
        return null;
    }

}
