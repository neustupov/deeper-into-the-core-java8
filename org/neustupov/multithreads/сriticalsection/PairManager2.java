package neustupov.multithreads.сriticalsection;

public class PairManager2 extends PairManager{
    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
