package com.bjsxt.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock2 {
    public static void main(String[] args) {
        ReadWriteLock rwl = new ReentrantReadWriteLock();


        Lock readLock = rwl.readLock();
        Lock readLock2 = rwl.readLock();
        Lock writeLock = rwl.writeLock();
        System.out.println(readLock==readLock2);
    }
}
