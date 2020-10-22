package neustupov.multithreads.newcomponents.delayqueue;

import java.util.concurrent.DelayQueue;

public class DelayedTaskConsumer implements Runnable{
    private final DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                q.take().run();
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
