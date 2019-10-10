package com.bjsxt.test;

public class NumSoutThreat extends Thread{
    private LockPro lockPro;
    NumSoutThreat(LockPro lockPro){
        this.lockPro = lockPro;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 52 ; i++){
            try {
                lockPro.PrNum(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
