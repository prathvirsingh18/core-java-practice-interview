package corejava.java8.multithreading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClass {

    public static void printI(){
        for(int i=0; i<100; i++){
        System.out.println("printin value from i : "+i);
    }}

    public static void printJ(){
            for(int j=0; j<100; j++){
                System.out.println("printin value from j : "+j);
    }}

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(()-> printI());
        executor.submit(()-> printJ());
        executor.shutdown();

    }
}
