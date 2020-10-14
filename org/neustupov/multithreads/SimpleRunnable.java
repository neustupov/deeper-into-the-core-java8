package neustupov.multithreads;

public class SimpleRunnable implements Runnable{

    private final int id;

    public SimpleRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Simple runnable" + id);
    }
}
