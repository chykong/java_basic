package com.critc.container;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 孔垂云 on 2017/4/17.
 * Set主要用法
 */
public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("abc");
        set.add("cde");
        set.add("efg");
        set.add("fgh");
        set.add("abc"); //重复的abc,set会自动将其去掉
        System.out.println("size=" + set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("输出set的值：" + it.next());
        }

    }
}
