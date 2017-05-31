package com.critc.generic.method;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class ObjectToolDemo {
    public static void main(String[] args) {
        // 定义泛型方法后
        ObjectTool ot = new ObjectTool();
        ot.show("hello");
        ot.show(100);
        ot.show(true);
    }
}
