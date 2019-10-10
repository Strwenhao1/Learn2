package com.bjsxt.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
测试使用线程池大量执行Runnable 命令

 */
public class TestThreadPool {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(10);

//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ExecutorService pool = Executors.newScheduledThreadPool(100);

        for (int i = 0; i < 100 ; i++){
            final int n = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("开始执行"+Thread.currentThread().getName()+" "+n);
                    System.out.println("结束执行"+Thread.currentThread().getName()+" "+n);
                }
            });
        }
        pool.shutdown();
    }

}
