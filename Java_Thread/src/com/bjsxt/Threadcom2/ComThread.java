package com.bjsxt.Threadcom2;

/*
消费者线程
 */
public class ComThread implements  Runnable{
    private Product product;
    ComThread(Product product){
        this.product = product;
    }
    @Override
    public void run() {
        while (true){
            product.Consu();
        }
    }
}
