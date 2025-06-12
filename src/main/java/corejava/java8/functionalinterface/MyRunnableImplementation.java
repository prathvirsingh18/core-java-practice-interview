package corejava.java8.functionalinterface;
//Note runnable is a functional interface it has only one abstract method
public class MyRunnableImplementation implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("Child thread");
        }

    }
}

class  TestFI{
    public static void main(String[] args) {
        //<----old school;-->
//        Runnable runnable = new MyRunnableImplementation();
//        Thread thread = new Thread(runnable);
//        thread.start();
//        for(int i=0;i<10;i++){
//            System.out.println("Parent thread");
//        }

        //<--- using lambda expression-->
        Runnable runnable1 = ()-> {for(int i=0; i<100; i++){
            System.out.println("Child thread");
        }};
        //runnable1.run();//it will directly run method and no new thread is used to execute it
        Thread t = new Thread(runnable1);// this means a new thread is used to execute it
        t.start();
        for(int i =0; i<100; i++){
            System.out.println("parent thread");
        }

        //-------- Other way of implementing old school method
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10;i++){
                    System.out.println("child thread t1");
                }
            }
        });
        t1.start();
        for(int i =0; i<100; i++){
            System.out.println("parent thread t1");
        }

    //<----- implemting using lambda expresison --->
    Thread th = new Thread(()->{
        for(int i =0; i<100; i++){
            System.out.println("child thread using lambda expression");
        }
    });
        th.start();
        for(int i =0; i<100; i++){
            System.out.println("parent thread th");
        }

}}
