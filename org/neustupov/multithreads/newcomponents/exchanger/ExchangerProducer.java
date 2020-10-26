package neustupov.multithreads.newcomponents.exchanger;

import neustupov.collection.generators.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerProducer<T> implements Runnable {

    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
