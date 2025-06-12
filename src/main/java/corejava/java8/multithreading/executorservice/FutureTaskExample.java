package corejava.java8.multithreading.executorservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c1 = ()->{
            List<Integer> li = Arrays.asList(
                    1,2,3,4,5,6,7,8,9
            );
            return li.stream().mapToInt(Integer::intValue).sum();
        };

        FutureTask<Integer> ft = new FutureTask<>(c1);
        Thread t1 = new Thread(ft);
        t1.start();
        System.out.println(ft.get());
    }
}
