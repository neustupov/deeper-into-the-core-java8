package neustupov.multithreads.newcomponents.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PrioritizedTaskConsumer implements Runnable {
    private final PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
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
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
