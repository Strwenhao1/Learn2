package com.bjsxt.sellTickets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class fountWin implements Runnable {
    private int tickte = 200;
    Object obj = new Object();
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            if(tickte>0){
                System.out.println(Thread.currentThread().getName()+"卖了第："+tickte+"张票");
                tickte--;
            }
            lock.unlock();
            if(tickte==0){
                break;
            }
        }
    }

//    public synchronized void sell(){
//        if(tickte>0){
//            System.out.println(Thread.currentThread().getName()+"卖了第："+tickte+"张票");
//            tickte--;
//        }
//    }
}
