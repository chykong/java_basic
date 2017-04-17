package com.critc;

import java.math.BigDecimal;

/**
 * Created by 孔垂云 on 2017/4/15.
 * BigDecimal基本操作
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println(2.06 + 2.01);

        BigDecimal a1=new BigDecimal(2.06);
        BigDecimal b1=new BigDecimal(2.01);
        System.out.println(a1.add(b1));//错误

        BigDecimal a2=new BigDecimal(String.valueOf(2.06));
        BigDecimal b2=new BigDecimal(String.valueOf(2.01));
        System.out.println(a2.add(b2));

        //精度计算
        BigDecimal c2=a2.add(b2).setScale(1,BigDecimal.ROUND_CEILING);
        System.out.println(c2);
    }
}
