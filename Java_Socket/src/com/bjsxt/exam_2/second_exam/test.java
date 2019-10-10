package com.bjsxt.exam_2.second_exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test {
static Lock lock = new ReentrantLock();



    static class  hole implements Runnable{
        private int crossedNum = 0;
//        public static int i = 1;
//        @Override
//        public void run() {
//        lock.lock();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"  "+i);
//            i++;
//            lock.unlock();
//        }

        @Override
        public void run() {
            lock.lock();
            try {  	//每个人通过山洞的时间为5秒（1分）
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//人数计数（0.5分）
            crossedNum++;
            //显示一下每次通过山洞人的姓名（1分）
            System.out.println(Thread.currentThread().getName()+
                    "通过了山洞，这是第"+crossedNum+"个用户");

            lock.unlock();
        }


        synchronized  void cross (){

        }


    }

    public static void main(String[] args) {
        hole i = new hole();
        Thread thread1 = new Thread(i,"小一");
        Thread thread2= new Thread(i,"小二");
        Thread thread3 = new Thread(i,"小三");
        Thread thread4 = new Thread(i,"小四");
        Thread thread5 = new Thread(i,"小五");
        Thread thread6 = new Thread(i,"小六");
        Thread thread7 = new Thread(i,"小七");
        Thread thread8 = new Thread(i,"小八");
        Thread thread9 = new Thread(i,"小九");
        Thread thread10 = new Thread(i,"小十");
       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();
       thread5.start();
       thread6.start();
       thread7.start();
       thread8.start();
       thread9.start();
       thread10.start();

    }
}
