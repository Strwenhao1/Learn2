package com.bjsxt.synch;

public class Accout {
    private int balance=600;

    public void withDraw(int balance){
       this.balance -= balance;
    }

    public int chaxun(){
//        System.out.println("余额："+this.balance);
        return this.balance;
    }
}
