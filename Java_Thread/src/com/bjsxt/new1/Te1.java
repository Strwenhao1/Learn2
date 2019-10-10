package com.bjsxt.new1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Te1 {
    public static void main(String[] args) {
        final Print  print = new Print();

        for (int i = 0 ;i < 3 ; i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int i = 0;i < 4;i++){
                        print.num1();
                    }
                }
            },i+"").start();
//            System.out.println(i);
        }
    }

}
class Print{
    int status = 0;
    int no = 1;
   public synchronized void  num1() {
        int threadName = Integer.parseInt(Thread.currentThread().getName());
        while ((status%3) != threadName) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("线程"+threadName+":");
            for (int i = 0; i < 5; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(no++);
            }

            System.out.println();
            this.notifyAll();
            status = (status%3)+1;

    }
}
