package com.bjsxt.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPro {
    private boolean flag=false;
    private int tag = 0;
    Lock lock = new ReentrantLock();
    Condition NumCondition = lock.newCondition();
    Condition ChaCondition = lock.newCondition();

    void PrNum(int i) throws InterruptedException {
        lock.lock();
        try {
            if (flag){
                NumCondition.await();
            }

            System.out.print(i);
            tag++;
            if(tag==2){
                tag = 0;
                flag = true;
                ChaCondition.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    void PrCha(int i) throws InterruptedException {
        lock.lock();
        try {
            if (!flag){
                ChaCondition.await();
            }
            System.out.print((char)(i+65));
            flag = false;
            NumCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}
