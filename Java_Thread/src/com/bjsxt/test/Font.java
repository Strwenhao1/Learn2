package com.bjsxt.test;

public class Font {
    public static void main(String[] args) {
        LockPro lockPro = new LockPro();
        Thread prN = new NumSoutThreat(lockPro);
        Thread prC = new ChaSoutThreat(lockPro);
        prN.start();
        prC.start();

    }
}
