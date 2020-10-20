package neustupov.multithreads.waxomatic;

public class Car {
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffered(){
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while (!waxOn){
            wait();
        }
    }
    public synchronized void waitForBuffering() throws InterruptedException{
        while (waxOn){
            wait();
        }
    }
}
