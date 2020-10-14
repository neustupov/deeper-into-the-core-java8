package neustupov.multithreads.daemons;

public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}
