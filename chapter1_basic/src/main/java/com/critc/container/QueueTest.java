package com.critc.container;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 孔垂云 on 2017/4/17.
 * queue的用法
 */
public class QueueTest {

    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q : queue) {
            System.out.println("循环队列：" + q);
        }
        System.out.println("---------------------");
        System.out.println("获取第一个元素并把这个删除：" + queue.poll()); //返回第一个元素，并在队列中删除


        System.out.println("---------------");
        System.out.println("获取第一个元素=" + queue.element()); //返回第一个元素，不移除,使用element()或peek()方法
        for (String q : queue) {
            System.out.println(q);
        }
    }
}
