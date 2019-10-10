package com.bjsxt.pool;

import java.util.concurrent.*;

/**
 * 使用线程池执行大量的Runnable命令（ command 任务）
 */
public class aa {
    public static void main(String[] args) {
        //1.创建一个线程池
        //线程池中只有一个线程，保证线程肯定存在
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        //线程池中有固定数量的线程
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //线程池中有可变数量的线程
        //ExecutorService pool = Executors.newCachedThreadPool();
        //线程池可以用来执行一些定时任务
        //ExecutorService pool = Executors.newScheduledThreadPool(10);
        //自定义线程池
//        ExecutorService pool = new ThreadPoolExecutor(100, 150,
//                60L, TimeUnit.MINUTES,
//                new SynchronousQueue<Runnable>());
        //2.使用线程池执行大量的Runnable命令
        for (int i = 0; i <100 ; i++) {
            int  n = i;//JDK1.8中final可以省略
            //Runnable command = new MyRunnable(i);
            Runnable command = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行开始"+n);
                    System.out.println("执行结束"+n);
                }
            };
            //Thread thread = new Thread(runnable);
            //thread.start();
            pool.execute(command);
        }

        //3.关闭线程池
        pool.shutdown();
    }
}
/*
class MyRunnable implements  Runnable{
    int i;
    public MyRunnable(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("开始执行"+i);
        System.out.println("结束执行"+i);
    }
}
*/
