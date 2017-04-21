package com.critc;

/**
 * Created by 孔垂云 on 2017/4/21.
 * 第一个线程，实现Runnable接口，完成run方法
 */
public class FirstThread implements Runnable {
    private String username;

    public FirstThread(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(username + i);
        }
    }

    public static void main(String[] args) {
        FirstThread ft1 = new FirstThread("张三");
        FirstThread ft2 = new FirstThread("李四");
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        t1.start();
        t2.start();
    }
}
