package corejava.java8.multithreading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable r1 = ()->{
          for(int i=0;i<15;i++){
              System.out.println("r1 : "+i);
          }
        };

        Runnable r2 = ()->{
            for(int i=16;i<30;i++){
                System.out.println("r2 : "+i);
            }
        };

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.shutdown();

    }
}
