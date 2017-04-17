package com.critc.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/4/17.
 * List操作
 */
public class ListTest {
    public static void main(String[] args) {
        // List基本操作
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<Integer> list2 = new ArrayList<>();
        //第一种循环输入方式
        for (String str : list) {
            System.out.println("第一种输出list值：" + str);
        }

        //第二种循环输出方式
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println("第二种输出list值：" + str);
        }

        //第三种循环输出方式
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println("第三种输出list值：" + it.next());
        }
        //第四种循环输出方式
        list.forEach(str -> System.out.println("JDK8中输出list值：" + str));
    }
}
