package corejava.java8.multithreading.usingInterface;

public class Test{

    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<100;i++){
//                    System.out.println("value of i is : "+i);
//                }
//            }
//        };
//
//        Thread t1 = new Thread(runnable);
//        t1.start();

        Thread t1  = new Thread(()-> {
            for(int i=0; i<100;i++){
                    System.out.println("value of i is : "+i);
                }
        });
        t1.start();
        for(int i=0; i<100;i++){
                    System.out.println("value of j is : "+i);
                }


    }
}
