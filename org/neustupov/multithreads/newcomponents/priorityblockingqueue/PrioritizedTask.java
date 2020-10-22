package neustupov.multithreads.newcomponents.priorityblockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private final Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequense = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequense.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(o.priority, priority);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PrioritizedTask{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

    public String summary() {
        return id + " : " + priority;
    }

    public static class EndSentinel extends PrioritizedTask {
        private final ExecutorService exec;

        public EndSentinel(ExecutorService exec) {
            super(-1);
            this.exec = exec;
        }

        @Override
        public void run() {
            int count = 0;
            for(PrioritizedTask pt : sequense){
                System.out.println(pt.summary());
                if(++count % 5 == 0){
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdown");
            exec.shutdownNow();
        }
    }
}
