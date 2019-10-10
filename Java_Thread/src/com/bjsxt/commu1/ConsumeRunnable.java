package com.bjsxt.commu1;

public class ConsumeRunnable implements Runnable {
    private ProduceFactory factory;

    public ConsumeRunnable(ProduceFactory factor) {
        this.factory = factor;
    }

    @Override
    public void run() {

        while (true){
            //消费一个商品
            factory.consume();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
