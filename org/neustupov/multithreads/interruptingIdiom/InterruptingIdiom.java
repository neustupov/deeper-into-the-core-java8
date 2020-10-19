package neustupov.multithreads.interruptingIdiom;

import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {

    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1100);
        t.interrupt();
    }
}
