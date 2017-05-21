package com.critc.generic.inf;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class InterImpl implements Inter<String> {
    @Override
    public void show(String t) {
        System.out.println(t);
    }
}
