package com.bjsxt.create2;

public class OtherThread implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("我是乌龟      "+Thread.currentThread().getName()+"   "
                    +Thread.currentThread().getPriority());
        }
    }
}
