package com.critc;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by 孔垂云 on 2017/4/8.
 */
public class StringUtilTest {


    public static void main(String[] args) {
        //判断字符串是否为null或""
        System.out.println(StringUtils.isEmpty("123"));
        //判断是否不为null或""
        System.out.println(StringUtils.isNotEmpty(""));

        //判断是否为空
        System.out.println(StringUtils.isBlank(""));
        //判断是否不为空
        System.out.println(StringUtils.isNotBlank(""));

        //判断当前字符串为null时替换成什么，""不替换
        System.out.println(StringUtils.defaultString(null, "defaultStr"));
        //判断当前字符串为null或“”时替换成什么
        System.out.println(StringUtils.defaultIfEmpty("", "defaultStr2"));

        //字符串比较
        System.out.println(StringUtils.equalsIgnoreCase("abc", "ABc"));

        //判断是否是数字
        System.out.println(StringUtils.isNumeric("123"));

        //拆分字符串
        String str[] = StringUtils.split("中华 人民   共和 ", " ");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        String str2[] = StringUtils.splitByWholeSeparatorPreserveAllTokens("中华 人民   共和 ", " ");
        for (int i = 0; i < str2.length; i++) {
            System.out.println("被忽略：" + str2[i]);
        }

        String str6[] = "中华 人民   共和 ".split(" ", -1);
        for (String s : str6)
            System.out.println("JDK拆分：" + s);

        //拼接字符串
        String[] str3 = new String[]{"12", "34"};
        System.out.println(StringUtils.join(str3, ","));

        //移除结尾字符为"\n", "\r", 或者 "\r\n".
        System.out.println(StringUtils.chomp("abcrabc\r"));

        //转换第一个字符为大写.如何第一个字符是大写原始返回
        System.out.println(StringUtils.capitalize("ddf"));

    }
}
