package corejava.java8.predicate;

import java.util.function.Predicate;

public class PredicateJoins {
    public static void main(String[] args) {
        int [] x = {10,20,30,14, 7 ,17};

        Predicate<Integer> pi = i->i>10;
        System.out.println("Greater than 10");
        method1(pi, x);
        System.out.println("Even Predicate");
        Predicate<Integer> evenPredicate = i->i%2==0;
        method1(evenPredicate, x);
        System.out.println("Return numbers not greater than 10");
        //we use negate method on pi predicate
        method1(pi.negate(), x);
        //and pi and evenpredicate it will return number greater than 10 and even
        System.out.println("Return numbers greater than 10 and even");
        method1(pi.and(evenPredicate), x);
        //similarly or is also there
    }

    static void method1(Predicate<Integer> pi, int[] x){
        for(int eachValue: x){
            if(pi.test(eachValue)){
                System.out.println(eachValue);
            }
        }
    }
}
