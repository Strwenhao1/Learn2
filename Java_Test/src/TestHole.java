public class TestHole {
    private int i = 1;

    public static void main(String[] args) {
        TestHole tr = new TestHole();
        Runnable rr = tr.new ru();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(rr, "Thread-" + i);
            t1.start();
        }

    }

    class ru implements Runnable {
        @Override
        public void run() {
            thro();
        }
    }

    public synchronized void thro() {

        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ",你是第" + i + "个通过山洞的");
        i++;
    }


}