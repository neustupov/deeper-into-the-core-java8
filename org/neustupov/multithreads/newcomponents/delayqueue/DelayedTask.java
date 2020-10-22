package neustupov.multithreads.newcomponents.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        return Long.compare(trigger, that.trigger);
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "id=" + id +
                ", delta=" + delta +
                '}';
    }

    public String summary() {
        return id + " : " + delta;
    }

    public static class EndSentinel extends DelayedTask{
        private final ExecutorService exec;

        public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }

        public void run(){
            for(DelayedTask pt : sequence){
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutDownNow()");
            exec.shutdownNow();
        }
    }
}
