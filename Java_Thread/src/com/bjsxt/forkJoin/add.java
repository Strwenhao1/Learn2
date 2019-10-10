package com.bjsxt.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class add {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ForkJoinPool pool = new ForkJoinPool();
        //创建任务

        Task task = new Task(0L,100L);
        //获得运算结果
        Future<Long> future = pool.submit(task);
        System.out.println(future.get());
        //结束线程池
        pool.shutdown();
    }
}
