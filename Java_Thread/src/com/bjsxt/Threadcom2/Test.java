package com.bjsxt.Threadcom2;

public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        ProduceThread produceThread = new ProduceThread();
        produceThread.setProduct(product);
        Thread thread1 = new Thread(produceThread);


        ComThread comThread = new ComThread(product);
        Thread thread2 = new Thread(comThread);

        thread1.start();
        thread2.start();
    }
}
