package com.bjsxt.test;

public class ChaSoutThreat extends Thread{
    private  LockPro lockPro;
    ChaSoutThreat(LockPro lockPro){
        this.lockPro = lockPro;
    }
    int i = 0;
    @Override
    public void run() {
        for (i =0 ; i <= 26 ; i++){
            try {
                lockPro.PrCha(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
