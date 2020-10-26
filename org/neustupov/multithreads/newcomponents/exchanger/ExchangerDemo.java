package neustupov.multithreads.newcomponents.exchanger;

import neustupov.collection.generators.BasicGenerator;
import neustupov.multithreads.newcomponents.semaphore.Fat;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {

    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(BasicGenerator.create(Fat.class), xc, producerList));
        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
