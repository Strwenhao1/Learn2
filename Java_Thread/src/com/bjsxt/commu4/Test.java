package com.bjsxt.commu4;

/***
 * 生产者消费者问题： 多个生产者和多个消费者
 *      还有多个商品  设置商品数量最多为10个
 */
public class Test {
    public static void main(String[] args) {

      final ProduceFactory factory = new ProduceFactory(30);

//        Runnable target1 = new ProduceRunnable(factory);
        Runnable target1 = new Runnable() {
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
        };
        //创建并启动多个生产者消费者线程
        for (int i = 0; i < 5; i++) {
            new Thread(target1,"生产者"+i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        //消费一个商品
                        factory.consume();

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "消费者" + i).start();
        }

    }
}
