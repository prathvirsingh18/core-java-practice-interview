package corejava.java8.multithreading.executorservice.callable;

import java.util.concurrent.*;

public class CallableImplementation implements Callable<String> {
    @Override
    public String call() {
        return "Hello World";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new CallableImplementation());
        System.out.println(future.get());
        executorService.shutdown();
    }
}
