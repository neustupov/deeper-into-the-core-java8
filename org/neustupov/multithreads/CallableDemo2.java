package neustupov.multithreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Callable<Object>> callableList = new ArrayList<>();
        List<Future<Object>> results = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            callableList.add(Executors.callable(new SimpleRunnable(i)));
        }
        try {
            results.addAll(exec.invokeAll(callableList));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
        for(Future<Object> fo : results){
            try {
                fo.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
