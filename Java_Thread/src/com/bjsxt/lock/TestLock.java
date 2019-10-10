package com.bjsxt.lock;

import javafx.scene.effect.Bloom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Lock lock2 = new ReentrantLock();
        lock2.tryLock();
        try {
            lock2.tryLock(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            lock2.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        lock2.unlock();
        lock2.newCondition();



    }

    public void method1() {
        lock.lock();

        try {
            method2();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        try {
            method3();
        } finally {
            lock.unlock();
        }
    }

    public void method3() {
        lock.lock();
        try {
            method1();
        } finally {
            lock.unlock();
        }
    }
}
