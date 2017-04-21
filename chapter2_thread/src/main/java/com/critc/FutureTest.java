package com.critc;

import java.util.concurrent.*;

/**
 * Created by 孔垂云 on 2017/4/21.
 */
public class FutureTest {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);//定义10个线程的线程池

    static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return "Hello Future";
        }
    }

    public static void main(String[] args) throws Exception {
        Future<String> future = executor.submit(new Task());
        System.out.println("开始执行线程：");
        String ret = future.get();//获取该线程的返回值
        System.out.println("执行结果：" + ret);
        System.out.println("执行完毕");
        executor.shutdown();
    }
}
