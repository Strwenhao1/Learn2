package com.bjsxt.sellTickets;

public class sellTickets {
    public static void main(String[] args) {
        Runnable runnable = new fountWin();
        Thread win1 = new Thread(runnable,"窗口1");
        Thread win2 = new Thread(runnable,"窗口2");
        Thread win3 = new Thread(runnable,"窗口3");
        Thread win4 = new Thread(runnable,"窗口4");
        win1.start();
        win2.start();
        win3.start();
        win4.start();
    }
}
