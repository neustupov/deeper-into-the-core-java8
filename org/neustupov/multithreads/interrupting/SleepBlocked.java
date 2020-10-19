package neustupov.multithreads.interrupting;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e){
            System.out.println("Interrupted Exception");
        }
        System.out.println("Exit SleepBlocked.run()");
    }
}
