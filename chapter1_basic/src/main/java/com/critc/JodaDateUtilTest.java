package com.critc;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by 孔垂云 on 2017/4/15.
 * 常用日期操作
 */
public class JodaDateUtilTest {
    public static void main(String[] args) {
        //日期格式化
        DateTime dateTime = new DateTime(2012, 12, 13, 16, 30);
        System.out.println("当前日期格式化：" + dateTime.toString("yyyyMMdd HHmmss"));

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMddHHmmss");
        DateTime d2 = DateTime.parse("20170402120023", format);
        System.out.println("字符串格式化成日期：" + d2);

        //两个日期间隔多少天
        LocalDate start = new LocalDate(2012, 12, 14);
        LocalDate end = new LocalDate(2013, 01, 15);
        int days = Days.daysBetween(start, end).getDays();
        System.out.println("两个日期间隔天数：" + days);
        int months = Months.monthsBetween(start, end).getMonths();
        System.out.println("两个日期间隔月数：" + months);

        //当前天增加多少天
        dateTime = dateTime.plusDays(31);
        System.out.println("当前日期增加多少天变为：" + dateTime);
        dateTime = dateTime.plusMonths(2);
        System.out.println("当前日期增加多少月变为：" + dateTime);

    }
}
