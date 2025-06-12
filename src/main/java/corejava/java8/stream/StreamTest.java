package corejava.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers = Arrays.asList(1,2,3,4,5,6,78,9,6,11,2);
        Predicate<Integer> pi = (num)-> num%2==0;
        Stream<Integer> integerStream = listOfIntegers.stream().filter(pi);
        List<Integer> evenNumbers = listOfIntegers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        integerStream.forEach(System.out::println);
        evenNumbers.forEach(System.out::println);

        //convert a string to lowercase from uppercase
        String s = "HELLO WORLD";
        Function<String, String> fs = x-> x.toLowerCase();
        System.out.println(fs.apply(s));

        List<String> ls = new ArrayList<>();
        ls = Arrays.asList("HELLO", "Hi", "WonderFul");
        List<String> stringList = ls.stream().map(fs).collect(Collectors.toList());
        System.out.println(stringList);


        //other method on stream
        //count
        long count = stringList.stream().count();
        System.out.println(count);

        //sort
        List<Integer> sortedIntegetList = listOfIntegers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedIntegetList);

        //we can use comparator it is also an functional interface
        //sorting in reverse order
        Comparator<Integer> com = (i1, i2)-> i2.compareTo(i1);
        List<Integer> sortredDecreasing = listOfIntegers.stream().sorted(com).collect(Collectors.toList());
        System.out.println(sortredDecreasing);


        //min max uses comparator
        Comparator<Integer> comparator = Integer::compareTo;
        //Comparator<Integer> comparator = (i1, i2) -> i1.compareTo(i2);
        Integer i = listOfIntegers.stream().min(comparator).get();
        System.out.println(i);
    //forEach
        listOfIntegers.forEach(x-> System.out.println(x));
    }


}
