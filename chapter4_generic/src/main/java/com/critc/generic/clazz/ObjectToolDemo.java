package com.critc.generic.clazz;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class ObjectToolDemo {

    public static void main(String[] args) {
        ObjectTool<String> ot = new ObjectTool<String>();
        ot.setObj(new String("中国"));
        String s = ot.getObj();
        System.out.println("姓名是：" + s);
        ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        ot2.setObj(new Integer(69));
        Integer i = ot2.getObj();
        System.out.println("年龄是：" + i);
    }
}
