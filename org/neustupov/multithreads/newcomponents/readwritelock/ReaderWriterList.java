package neustupov.multithreads.newcomponents.readwritelock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<>(Collections.nCopies(size, initialValue));
    }

    public T set(int index, T element) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }

    public T get(int index) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            if (lock.getReadLockCount() > 1) {
                System.out.println(lock.getReadLockCount());
            }
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        new ReaderWriterListTest(30, 1);
    }
}
