package neustupov.multithreads.notifyvsnotifyall;

public class Task implements Runnable{
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
