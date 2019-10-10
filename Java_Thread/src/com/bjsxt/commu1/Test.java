package com.bjsxt.commu1;

/***
 * 生产者消费者问题： 多个生产者和多个消费者
 *      还有多个商品  设置商品数量最多为10个
 */
public class Test {
    public static void main(String[] args) {

        ProduceFactory factory = new ProduceFactory();

        Runnable target1 = new ProduceRunnable(factory);
        //创建并启动多个生产者消费者线程
        for (int i = 0; i < 5; i++) {
            new Thread(target1,"生产者"+i).start();
        }

        Runnable target2 = new ConsumeRunnable(factory);
        for (int i = 0; i < 10; i++) {
            new Thread(target2,"消费者"+i).start();
        }

    }
}
