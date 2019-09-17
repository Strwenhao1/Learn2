package com.bjsxt.create;

public class OtherThread extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("我是乌龟      " + this.getName() + "   " + this.getPriority());
        }
    }
}
