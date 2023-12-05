package com.yzxaz.gentools.utils;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


/**
 * @author junan
 * @version V1.0.0
 * @className StrUtil
 * @desc
 * @date 2020/7/31 21:56
 */
@SuppressWarnings("all")
public class StringUtils {

    /**
     * ����ĸתСд
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * ����ĸת��д
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    public static String stringList2string(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (StrUtil.isEmpty(s)) {
                continue;
            }
            sb.append(",").append(s.trim());
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        }
        return null;
    }

    public static String longList2string(List<Long> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Long l : list) {
            if (l == null) {
                continue;
            }
            sb.append(",").append(l.toString());
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        }
        return null;
    }

    public static <T> String list2string(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (T l : list) {
            if (l == null) {
                continue;
            }
            sb.append(",").append(l.toString());
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        }
        return null;
    }

    public static <T> String list2string(List<T> list, String separate) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (T l : list) {
            if (l == null) {
                continue;
            }
            sb.append(separate).append(l.toString());
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        }
        return null;
    }


    /**
     * @param str �Զ��ŷָ����ַ���
     */
    public static List<String> String2StringList(String str) {
        if (StrUtil.isEmpty(str)) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String[] strArr = str.split(",");
        for (String s : strArr) {
            if (!StrUtil.isEmpty(s)) {
                list.add(s);
            }
        }
        return list;
    }

    /**
     * �ַ��� תList
     *
     * @param strs   �ַ���
     * @param regexp ����ַ�������
     * @return List<String>
     */
    public static List<String> toStringList(String strs, String regexp) {
        if (StrUtil.isEmpty(strs)) {
            return null;
        }
        String[] arrayStr = strs.split(regexp);
        List<String> strList = new ArrayList<>();
        for (String s : arrayStr) {
            if (StrUtil.isEmpty(s)) {
                continue;
            }
            strList.add(s.trim());
        }
        return strList.isEmpty() ? null : strList;
    }

    public static List<Long> String2LongList(String str) {
        if (StrUtil.isEmpty(str)) {
            return null;
        }
        List<Long> list = new ArrayList<>();
        String[] strArr = str.split(",");
        for (String s : strArr) {
            if (!StrUtil.isEmpty(s)) {
                list.add(Long.valueOf(s));
            }
        }
        return list;
    }

    /**
     * �ַ����ָ��ɼ���
     *
     * @param str    �ַ���
     * @param regexp �ָ���
     * @return ���
     */
    public static List<Integer> String2IntList(String str, String regexp) {
        if (StrUtil.isEmpty(str)) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        String[] strArr = str.split(regexp);
        for (String s : strArr) {
            if (!StrUtil.isEmpty(s)) {
                list.add(Integer.valueOf(s));
            }
        }
        return list;
    }

    public static List<Integer> String2IntList(String str) {
        if (StrUtil.isEmpty(str)) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        String[] strArr = str.split(",");
        for (String s : strArr) {
            if (!StrUtil.isEmpty(s)) {
                list.add(Integer.valueOf(s));
            }
        }
        return list;
    }

    /**
     * ��ȡָ�����������
     *
     * @param len ����
     * @return ���
     */
    public static String getRandomStr(int len) {
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, len - 1));
        return String.valueOf(rs);
    }


    /**
     * �����̶����ȵ�����ַ���
     *
     * @param length ����
     * @return ���
     */
    public static String getRandomString(int length) {
//		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * �����ֻ��ţ��м�4λ�滻Ϊ*(��������)
     *
     * @param phone �ֻ���
     * @return �滻���ֻ���
     */
    public static String encodePhone(String phone) {
        if (StrUtil.isEmpty(phone) || phone.length() < 4) {
            return phone;
        }
        String encodePhone = phone.substring(0, 3) + "****";
        if (phone.length() > 7) {
            encodePhone += phone.substring(7);
        }
        return encodePhone;
    }


    /**
     * �Ƚ������ַ�����ֵ�Ƿ�һ��
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        return Objects.equals(str1, str2);
    }


    public static boolean hasText(String str) {
        return str != null && !str.isEmpty() && containsText(str);
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();

        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

}
