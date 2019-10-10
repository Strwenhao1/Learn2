package com.bjsxt.new1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Te3 {
    public static void main(String[] args) {

        final Sales sales = new Sales(30);

            new Thread(new Runnable(){
                @Override
                public void run() {
                    sales.sale1();
                }
            },"线程"+1).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                sales.sale2();
            }
        },"线程"+2).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                sales.sale3();
            }
        },"线程"+3).start();

    }
}
class Sales{
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public Sales(int count){
        this.count = count;
    }

    public void sale1() {
        while (count > 0){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"  :  "+count);
                count--;
                c2.signalAll();
                c3.signalAll();
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
            lock.unlock();
            }
        }
    }

    public void sale2() {
        while (count > 0){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"  :  "+count);
                count--;

                try {
                    c1.signalAll();
                    c3.signalAll();
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void sale3() {
        while (count > 0){
            try {

                lock.lock();
                c2.signalAll();
                c1.signalAll();
                System.out.println(Thread.currentThread().getName()+"  :  "+count);
                count--;
                try {
                    if(count > 0){

                        c1.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }
    }

}