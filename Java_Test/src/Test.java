import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;

public class Test{
    public int j = 0;
    public static void main(String[] args){
        Test test = new Test();
        Runnable run1 = test.new adThread();
        Runnable run2 = test.new miThread();
        DataFormat d = new DataFormat();

        DataFormat df = new DataFormat("yyyy-mm-dd");
        for(int i = 0 ; i < 2 ; i++){
            Thread t1 = new Thread(run1);
            Thread t2 = new Thread(run2);
            t1.start();
            t2.start();
        }

    }

    private synchronized void add(){
        j++;
        System.out.println("正在进行加的操作，i："+j);
    }

    private synchronized void mi(){
        j--;
        System.out.println("减减,i:"+j);
    }



    public class adThread implements Runnable {
        int i = 100;
        @Override
        public void run(){
            while (i>0){
                add();
                i--;
            }
        }
    }

    public class miThread implements Runnable {
        int i = 100;
        @Override
        public void run(){
            while (i>0){
                mi();
                i--;
            }
        }
    }



}