package com.critc.generic.inf;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class GenericDemo {
    public static void main(String[] args) {
        // 泛型如果明确的写的时候，前后必须一致 Collection<Object> c1 = new ArrayList<Object>();
        // Collection<Object> c2 = new ArrayList<Animal>();//报错
        // Collection<Object> c3 = new ArrayList<Dog>();//报错
        // Collection<Object> c4 = new ArrayList<Cat>();//报错

        // ?表示任意的类型都是可以的
        Collection<?> c5 = new ArrayList<Object>();
        Collection<?> c6 = new ArrayList<Animal>();
        Collection<?> c7 = new ArrayList<Dog>();
        Collection<?> c8 = new ArrayList<Cat>();

        // ? extends E:向下限定，E及其子类
        // Collection<? extends Animal> c9 = new ArrayList<Object>();//报错
        Collection<? extends Animal> c10 = new ArrayList<Animal>();
        Collection<? extends Animal> c11 = new ArrayList<Dog>();
        Collection<? extends Animal> c12 = new ArrayList<Cat>();

        // ? super E:向上限定，E极其父类
        Collection<? super Animal> c13 = new ArrayList<Object>();
        Collection<? super Animal> c14 = new ArrayList<Animal>();
        // Collection<? super Animal> c15 = new ArrayList<Dog>();//报错
        // Collection<? super Animal> c16 = new ArrayList<Cat>();//报错
    }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
