package com.critc.container;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/4/17.
 * List删除操作
 */
public class ListRemoveTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

       /* for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            list.remove(str);
            System.out.println("剩余元素:" + list.toString());
        }*/

        //从list的最后一个元素进行循环
        for (int i = list.size() - 1; i >= 0; i--) {
            String str = list.get(i);
            list.remove(str);
            System.out.println("剩余元素:" + list.toString());
        }
    }
}
