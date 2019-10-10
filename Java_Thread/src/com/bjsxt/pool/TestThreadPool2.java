package com.bjsxt.pool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static javafx.scene.input.KeyCode.F;

/*

测试使用线程池 执行大量的Callable命令
 */
public class TestThreadPool2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<>();
        Future<Integer>[]  futures = new Future[100];
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return new Random().nextInt(20);
                }
            });
            futures[i] = future;
            futureList.add(future);
        }

//        Iterator<Future<Integer>> it = futureList.iterator();
//        while (it.hasNext()){
//            Future<Integer> f = it.next();
//            System.out.println(f.get());
//        }

//        for (Future<Integer> f:futureList){
//            System.out.println(f.get());
//        }

        for (int i = 0 ; i < 100;i++){
            System.out.println(futures[i].get());
        }


        pool.shutdown();
    }


}
