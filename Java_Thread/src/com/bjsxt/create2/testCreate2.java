package com.bjsxt.create2;

public class testCreate2 {
    public static void main(String[] args) {
//        Runnable runnable1 = new OtherThread();
//        Thread thread1 = new Thread(runnable1);
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                Thread.currentThread().setPriority(10);
                while (true){
                    System.out.println("我是乌龟      "+Thread.currentThread().getName()+"   "
                            +Thread.currentThread().getPriority());
                }
            }
        });
        thread1.start();


        while (true){
            System.out.println("我是兔子  兔子  兔子  "+Thread.currentThread().getName()+"    "+
                    Thread.currentThread().getPriority());
        }
    }

}
