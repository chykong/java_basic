package com.critc;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by 孔垂云 on 2017/4/21.
 */
public class ExecutorTest {
    private static Executor executor = Executors.newFixedThreadPool(10);//新建一个10个线程的执行

    /**
     * 内部类实现一个线程
     */
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());//打印当前线程的名称
            try {
                Thread.sleep(new Random().nextInt(10) * 1000);//暂定几秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }
    }
}
