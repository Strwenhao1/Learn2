package com.bjsxt.synch;

public class fountRun {
    public static void main(String[] args) {
        Runnable runnable = new accountThread();
        Thread zhangsan = new Thread(runnable);
        zhangsan.setName("张三");
        Thread zhangsanwife = new Thread(runnable);
        zhangsanwife.setName("张三妻");
        zhangsan.start();
        zhangsanwife.start();
    }
}
