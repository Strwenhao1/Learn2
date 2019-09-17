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
//            synchronized (product) {
//                if (product.getFlag() == 1) {
//                    try {
//                        product.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (i % 2 == 0) {
//                    product.setName("馒头");
//                    product.setColor("白色");
//                    System.out.println("生产者生产：" + product.getName() + "  " + product.getColor());
//                } else {
//                    product.setName("玉米饼");
//                    product.setColor("黄色");
//                    System.out.println("生产者生产：" + product.getName() + "  " + product.getColor());
//                }
//                product.setFlag(1);
//                product.notify();
//            }

            if (i % 2 == 0) {
               product.Produc("馒头", "白色");
            } else {
               product.Produc("玉米饼", "黄色");
            }
            i++;
        }

    }
}
