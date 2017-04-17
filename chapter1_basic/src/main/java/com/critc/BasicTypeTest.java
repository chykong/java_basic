package com.critc;

/**
 * Created by 孔垂云 on 2017/4/15.
 * java 基本类型和包装类型的区别
 * java里面Integer在-128-127之间，两个Integer对象是可以直接相等的，如果不在这个范围内，需要用equals来进行比较
 */
public class BasicTypeTest {
    public static void main(String[] args) {
        int a1=127,b1=127,a2=128,b2=128;
        System.out.println(a1==b1);
        System.out.println(a2==b2);


        Integer a3=127,b3=127,a4=128,b4=128;
        System.out.println(a3==b3);
        System.out.println(a4==b4);
        System.out.println(a3.equals(b3));
        System.out.println(a4.equals(b4));


        char c1 = 'h',c2 = 'e',c3='l',c4='l',c5 = 'o';
        System.out.print(c1);
        System.out.print(c2);
        System.out.print(c3);
        System.out.print(c4);
        System.out.print(c5);
        System.out.println("测试git");
    }
}
