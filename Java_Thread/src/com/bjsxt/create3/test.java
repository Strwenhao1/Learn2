package com.bjsxt.create3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class test implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return (new Random()).nextInt(20);
    }

    public static void main(String[] args) throws Exception {
        Callable<Integer> c = new test();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(c);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
