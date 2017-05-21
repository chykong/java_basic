package com.critc.generic.inf;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class InterDemo {

    public static void main(String[] args) {
        // 第一种情况的测试
        Inter<String> i = new InterImpl();
        i.show("hello");
        // 第二种情况的测试
        Inter<String> i2 = new InterImpl2<String>();
        i2.show("hello");
        Inter<Integer> i3 = new InterImpl2<Integer>();
        i3.show(100);
    }
}
