package neustupov.multithreads.threadVariations;

import static java.lang.Thread.sleep;

public class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name){
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            };

            @Override
            public String toString() {
                return t.getName() + countDown;
            }
        }, name);
        t.start();
    }
}
