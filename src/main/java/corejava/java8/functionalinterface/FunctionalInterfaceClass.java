package corejava.java8.functionalinterface;

public class FunctionalInterfaceClass implements  LearnFunctionalInterface{
    @Override
    public void run() {
        System.out.println("running run method");
    }
}
class Test{
    public static void main(String[] args) {
       //This is long way we need to create above class and provide implementation of run method
        //then creating a objeect of class and then accessing it
        LearnFunctionalInterface lfi = new FunctionalInterfaceClass();
        lfi.run();

        //<------Below is sortand way using lambda expression by functional interface
        //Functional interface allow us to implement lambda expression
        //Below we are using run method of LearnFunctionalInterface and giving it definition
        LearnFunctionalInterface lf = ()-> System.out.println("hello world");
        lf.run();
    }
}