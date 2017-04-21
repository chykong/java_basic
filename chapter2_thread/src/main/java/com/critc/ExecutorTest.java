package com.critc;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 孔垂云 on 2017/4/21.
 */
public class ExecutorTest {
    private static Executor executor = Executors.newFixedThreadPool(10);//新建一个10个线程的线程池

    /**
     * 内部类实现一个线程
     */
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());//打印当前线程的名称
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));//暂停几秒钟
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
