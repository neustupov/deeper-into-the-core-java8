package neustupov.multithreads.сriticalsection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager {

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        try {
            lock.lock();
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
