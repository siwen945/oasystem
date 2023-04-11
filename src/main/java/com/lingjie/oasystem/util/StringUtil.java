package com.lingjie.oasystem.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 默认字符串拼接间隔符
     */
    public static final String DEFAULT_SPLIT = ",";


    private static final char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 判断传入的字符串是否为空（含trim处理）
     *
     * @param str 字符串
     * @return 为空时true，否则false
     * @author zejun.dong
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断传入的字符串是否不为空（含trim处理）
     *
     * @param str 字符串
     * @return 不为空时true，否则false
     * @author zejun.dong
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断传入的字符串是否为空（不含trim处理）
     *
     * @param str 字符串
     * @return 为空时true，否则false
     * @author zejun.dong
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断传入的字符串是否不为空（不含trim处理）
     *
     * @param str 字符串
     * @return 不为空时true，否则false
     * @author zejun.dong
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * List<String>转换成拼接字符串
     *
     * @param strList   字符串List
     * @param splitMark 分隔字符标准
     * @return 转换后的拼接字符串
     * @author zejun.dong
     */
    public static String list2String(List<String> strList, String splitMark) {

        if (strList == null) {
            return EMPTY;
        }

        String result = "";
        for (String s : strList) {
            result += s + splitMark;
        }

        return result.substring(0, result.length() - splitMark.length());
    }

    /**
     * List<String>转换成拼接字符串（使用默认分隔符号）
     *
     * @param strList 字符串List
     * @return 转换后的拼接字符串
     * @author zejun.dong
     */
    public static String list2String(List<String> strList) {

        return list2String(strList, DEFAULT_SPLIT);
    }

    /**
     * 判断某字符（串）是否存在于源字符串中，
     * 任一参数值为null时返回false
     *
     * @param str
     * @param s
     * @return
     * @author zejun.dong
     */
    public static boolean contains(String source, String s) {
        if (source == null || s == null) {
            return false;
        }
        return source.contains(s);
    }

    /**
     * Byte数组转换为十六进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytes2String(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
            sb.append(byte2HEX(b));
        }
        return sb.toString();
    }

    /**
     * Byte转换为十六进制字符串
     *
     * @param ib
     * @return
     */
    public static String byte2HEX(byte ib) {
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

    public static void main(String[] args) {

    }

    /**
     * 减少字符
     * @param res
     * @return
     */
    public static String reduceStr(String res) {
        if (StringUtil.isNotEmpty(res)) {
            return res.length() > 600 ? res.substring(0, 600) : res;
        }
        return res;
    }
}
