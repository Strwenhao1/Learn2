package com.bjsxt.exam_1.second_exam;

public class test {
    private int i = 100;

    private  void asd() {
        while (true){
            i--;
            System.out.println(i);
        }
    }

    private   void add1() {
        while (true){
            i++;
            System.out.println(i);
        }
    }

    class mi implements Runnable {
        @Override
        public void run() {
            asd();
        }
    }

    class add implements Runnable {
        @Override
        public void run() {
            add1();
        }
    }



    public static void main(String[] args) {

        test t = new test();
        add at1 = t.new add();
        mi mt1 = t.new mi();
        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at1);
        Thread t3 = new Thread(mt1);
        Thread t4 = new Thread(mt1);
        t2.start();
        t3.start();

        t4.start();
        t1.start();






    }
}
