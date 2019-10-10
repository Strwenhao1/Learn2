package com.bjsxt.Threadcom3;

public class ProduceThread implements Runnable {
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i % 2 == 0) {
               product.Produc("馒头", "白色");
            } else {
               product.Produc("玉米饼", "黄色");
            }
            i++;
        }

    }
}
