package corejava.java8.multithreading.usingInterface;

public class Area implements Runnable{
    @Override
    public void run(){
        for(int i=0; i< 100;i++){
            System.out.println("Value of i : "+ i);
        }
    }

    public static void main(String[] args) {
        Area area = new Area();
        Thread t1 = new Thread(area);
        t1.start();

        for(int i = 0; i<120;i++){
            System.out.println("value of j is : "+ i);
        }
    }
}
