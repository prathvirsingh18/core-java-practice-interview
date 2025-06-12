package corejava.java8.multithreading.usingThreadClass;

public class MyClass extends Thread{
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("value of i"+i);
        }
 }

    public static void main(String[] args) {
        Thread thread = new MyClass();
        thread.start();

        for(int j=0; j<100;j++){
            System.out.println("value of j is: "+j);
        }
    }
}
