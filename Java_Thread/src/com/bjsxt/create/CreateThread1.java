package com.bjsxt.create;

public class CreateThread1 {
    public static void main(String[] args){
        Thread thread1 = new OtherThread();
        thread1.start();
        int o = 200;
        while (o>=0){
            System.out.println("我是兔子  兔子  兔子  "+Thread.currentThread().getName()+"    "+
                    Thread.currentThread().getPriority());
            o--;
        }
        thread1.interrupt();
    }
}
