package corejava.java8.predicate;

import java.util.function.Predicate;

public class PredicateLearn {
    public static void main(String[] args) {
        //predicate to check if i >20
        Predicate<Integer> p = i-> (i>20);

        System.out.println(p.test(10));
        System.out.println(p.test(30));

        //predicate to check if length of string is greater than 5
        Predicate<String> sp = i-> (i.length()>5);
        System.out.println(sp.test("hjekOO"));
        System.out.println(sp.test("hello"));

    }
}
