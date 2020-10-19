package neustupov.multithreads.interruptingIdiom;

import java.util.concurrent.TimeUnit;

public class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 1; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / 2;
                        }
                        System.out.println("Finishing time-consuming operation");
                    } finally {
                        n2.cleanUp();
                    }
                } finally {
                    n1.cleanUp();
                }
            }
            System.out.println("Exiting while()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception");
        }
    }
}
