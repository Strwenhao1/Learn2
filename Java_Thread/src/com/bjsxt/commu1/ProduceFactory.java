package com.bjsxt.commu1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 商品工厂
 */
public class ProduceFactory {
    private List<String> list = new ArrayList<>();
    private int max = 10;
    private int min = 0;
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
