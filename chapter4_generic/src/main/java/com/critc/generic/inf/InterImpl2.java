package com.critc.generic.inf;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class InterImpl2<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}