package com.bjsxt.new1;

import java.util.ArrayList;
import java.util.List;

public class Te2 {
    public static void main(String[] args) throws InterruptedException {
        final MyContainer c = new MyContainer();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int n = 0; n < 10; n++) {
                        c.add(new Object());
                    }

                }
            }, "add-" + i).start();
        }
        Thread.sleep(10);

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int n = 0; n < 10; n++) {
                        System.out.println(Thread.currentThread().getName() + "get-" + c.get(0));

                    }
                }
            }, "get-" + i).start();
        }
    }

}

class MyContainer {
    List list = new ArrayList();
    final Object writeLock = new Object();
    boolean isWrite = false;

    boolean isRead = false;

    public void add(Object obj) {
        while (isRead) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (writeLock) {
            try {
                while (isWrite) {
                    try {
                        writeLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isWrite = true;
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "add-" + obj);
                writeLock.notifyAll();
            } finally {
                isWrite = false;
            }
        }
    }

    public Object get(int index) {
        if (index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (isWrite) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            isRead = true;

            Object value = list.get(index);
            return value;
        } finally {
            isRead = false;
        }
    }
}
