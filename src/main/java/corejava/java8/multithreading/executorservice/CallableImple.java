package corejava.java8.multithreading.executorservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableImple implements Callable<Integer> {
    @Override
    public Integer call() throws Exception{
        List<Integer> intList = Arrays.asList(1,5,2,2,4,441,4,4,223,456,45614,21,45);
        return intList.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future1 = executorService.submit(new CallableImple());


        Callable<Integer> c1 = ()->{
            String s = "Hello World";
            return s.length();
        };

        Callable<String> c2 = ()->{
            return "Hello World";
        };

        Callable<List<Integer>> c3 = ()->{
            return Arrays.asList(1,5,2,2,4,441,4,4,223,456,45614,21,45);
        };

        Future<Integer> future2  = executorService.submit(c1);
        Future<String> future3  = executorService.submit(c2);
        Future<List<Integer>> future4 = executorService.submit(c3);
        Future<Integer> future5 =  executorService.submit(new Callable(){
            @Override
            public String call() throws Exception {
                return "callable called";
            }
        });

        Future<Integer> future6 =  executorService.submit(new Callable(){
            @Override
            public String call() throws Exception {
                return "callable called";
            }
        });
        System.out.println(future1.get() + " "+ future2.get()+" "+future3.get()+ " "+future4.get()+" "+future5.get()+ " "+future6.get());
        executorService.shutdown();



    }

}
