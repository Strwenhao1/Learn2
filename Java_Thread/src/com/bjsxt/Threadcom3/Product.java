package com.bjsxt.Threadcom3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private String name;
    private String color;
    private int flag = 0;
    Lock lock = new ReentrantLock();
    Condition comCondition = lock.newCondition();
    Condition proCondition = lock.newCondition();


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Product(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void Produc(String name,String color) {
        lock.lock();
        try {
            if (this.getFlag() == 1) {
                try {
                    proCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            this.color = color;
            System.out.println("生产者生产：" + this.getName() + "  " + this.getColor());
            this.setFlag(1);
            comCondition.signal();
        }finally {
            lock.unlock();
        }

    }


    public void Consu() {

        lock.lock();
        try {

            if (this.getFlag() == 0) {
                try {
                    comCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者 消费了" + this.getName() + "   " + this.getColor());
            this.setFlag(0);
            proCondition.signal();
        }finally {
            lock.unlock();
        }

    }



}
