package com.bjsxt.commu1;

/**
 * 生产者线程
 * (实际上是生产者所要执行的任)
 */
public class ProduceRunnable implements Runnable {
    private ProduceFactory factory;


    public ProduceRunnable(ProduceFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i = 1;
        while (true){
            factory.produce("商品"+i);
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
