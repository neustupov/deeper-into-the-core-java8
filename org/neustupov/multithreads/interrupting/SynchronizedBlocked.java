package neustupov.multithreads.interrupting;

public class SynchronizedBlocked implements Runnable {

    public synchronized void f(){
        while (true){
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(this::f).start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
