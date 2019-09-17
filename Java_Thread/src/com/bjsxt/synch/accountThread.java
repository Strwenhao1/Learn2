package com.bjsxt.synch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class accountThread implements Runnable {
    private final Accout accout = new Accout();
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();

        try {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (accout.chaxun() > 400) {

                accout.withDraw(400);
                System.out.println("取款成功，" + Thread.currentThread().getName() + "。余额：" + accout.chaxun());
            } else {
                System.out.println("取款失败，" + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();
        }

    }


}
