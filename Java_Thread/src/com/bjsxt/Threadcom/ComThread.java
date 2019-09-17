package com.bjsxt.Threadcom;
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
            synchronized (product){
                if(product.getFlag()==0){
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("消费者 消费了"+product.getName()+"   "+product.getColor());
                    product.setFlag(0);
                    product.notify();
            }

        }
    }
}
