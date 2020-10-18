package neustupov.multithreads.сriticalSection;

public class PairManipulator implements Runnable{

    private final PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true){
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "PairManipulator{" +
                "pm=" + pm +
                '}' + " Pm - " + pm.getPair() + " counter- " + pm.checkCounter.get();
    }
}
