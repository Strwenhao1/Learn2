package com.bjsxt.volatile1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    private static volatile boolean flag = true;
    public static void main(String[] args)  throws Exception{
   LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.put(1);
        linkedBlockingQueue.add(1);
        linkedBlockingQueue.take();

//         int i = 0 ;
        //创建一个线程并启动
        new Thread(){
            int i = 0;
            @Override
            public void run() {
                while (flag){

                }
            }
        }.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;

    }
}
