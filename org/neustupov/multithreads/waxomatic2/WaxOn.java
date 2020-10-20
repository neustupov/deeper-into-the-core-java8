package neustupov.multithreads.waxomatic2;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffering();
            }
        } catch (InterruptedException e){
            System.out.println("Exiting wia interrupt");
        }
        System.out.println("Ending wax on task");
    }
}
