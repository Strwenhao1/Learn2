package com.bjsxt.lock2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读操作 写操作
 * 对读操作使用读锁  对写操作上写锁
 * 读锁共享锁  可以多个线程同时获取
 * 写锁是排他锁，独占锁，一个线程得到写锁后，其它线程要获得写锁会阻塞
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        final Operator operator = new Operator();
        for (int i = 0; i < 5; i++) {
            new Thread("读线程" + i) {
                @Override
                public void run() {
                    while (true) {
                        operator.read();
                    }
                }
            }.start();
        }


        for (int i = 0; i < 5; i++) {
            new Thread("写线程" + i) {
                @Override
                public void run() {
                    while (true) {
                        operator.write();
                    }
                }
            }.start();
        }
    }


}

class Operator {
    /**
     * 读操作，要添加读锁，希望多个线程同时存取，提高效率
     */

//    private Lock lock = new ReentrantLock();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void read() {
        rwl.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始读取数据......");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取数据完毕.........");
        } finally {
            rwl.readLock().unlock();
        }

    }

    public void write() {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写数据......");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "写数据完毕.........");
        } finally {
            rwl.writeLock().unlock();
        }

    }
}