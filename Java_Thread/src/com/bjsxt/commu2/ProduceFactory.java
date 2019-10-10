package com.bjsxt.commu2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 商品工厂
 *
 * 1.如果有多个线程，将wait放在while循环中。当线程被唤醒时，会进行重新的条件判断，使其再次阻塞
 * 2.仓库中的商品数量可以动态指定，可以通过构造方法或者setter方法提供
 * 3.生产者和消费者线程可以使用匿名内部类的方式实现。
 *      匿名内部类可以访问外部的成员变量
 *      匿名内部类可以访问外部类当前方法中的局部变量（使用final修饰，<=1.7）
 *
 * 4.使用同步方法或者同步代码块（synchronized），所有的线程（多个生产者和消费者）都在同一个等待队列
 * 这些线程使用了同一个同步监视器（this），唤醒的时候无法确定唤醒哪一个
 *
 *  可以使用lock锁来保证，将生产者和消费者放在两个等待队列中，即lock产生多个Condition
 */
public class ProduceFactory {
    private List<String> list = new ArrayList<>();
    private int max = 10;


    public ProduceFactory(int max) {
        this.max = max;
    }

    /**
     * 生产商品
     * @param produceName
     */
    public synchronized void produce(String  produceName){
        while (list.size()==max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产商品
        list.add(produceName);
        System.out.println(Thread.currentThread().getName()+"生产商品:"+produceName+"，目前商品数量："+list.size());

        this.notify();

    }

    /**
     * 消费商品
     */
    public synchronized void consume(){
        while(list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String productName = list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费商品："+productName+",目前数量："+list.size());
        this.notify();
    }
}
