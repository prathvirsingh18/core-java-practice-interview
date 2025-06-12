package corejava.java8.stream;

import javax.swing.text.html.Option;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream100Question {
    public static void main(String[] args) {
        //Filter even numbers from a list of integers
        List<Integer> numbers = Arrays.asList(1,2,23,3,15,545,5,5125,56,56,445);
        List<Integer> listOfEvenNumbers = numbers.stream().filter(x->x%2==0).toList();
        System.out.println(listOfEvenNumbers);

        //Convert a list of strings to uppercase.
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> upperCaseLetterList = words.stream().map(String::toUpperCase).toList();
        System.out.println(upperCaseLetterList);

        //Count the number of strings that start with 'A'
        List<String> names = Arrays.asList("Alex", "Bob", "Alice", "David");
        List<String> listOfNamesStartsWithA = names.stream().filter(s->s.startsWith("A")).toList();
        System.out.println(listOfNamesStartsWithA);

        //Create a list of square numbers
        List<Integer> number_s = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareOfNumbers = number_s.stream().map(i->i*i).toList();
        System.out.println(squareOfNumbers);

        //Find the first element in a list greater than 10
        List<Integer> numbers_greater_10 = Arrays.asList(5, 9, 12, 4, 18);
        Optional<Integer> firstNumberGreaterThan10 = numbers_greater_10.stream().filter(n->n>10).findFirst();
        System.out.println(firstNumberGreaterThan10.get());

        //Remove null values from a list.
        List<String> items = Arrays.asList("A", null, "B", null, "C");
        List<String> itemsAfterRemovingNull = items.stream().filter(Objects::nonNull).toList();
        System.out.println(itemsAfterRemovingNull);

        //Find the maximum number from a list.
        List<Integer> numbers_list = Arrays.asList(25, 3, 6, 9, 12);
        Optional<Integer> max_number = numbers_list.stream().max(Integer::compare);
        System.out.println(max_number.get());

        //Join strings with a comma.
        List<String> array_items = Arrays.asList("Java", "Python", "C++");
        String joined_string = array_items.stream().collect(Collectors.joining(","));
        System.out.println(joined_string);

        //Sort a list of strings alphabetically.
        List<String> namesOfAnimal = Arrays.asList("Zoe", "Adam", "Bob");
        List<String> sortedNameOfAnimals = namesOfAnimal.stream().sorted().toList();
        List<String> sortedNameOfAnimals1 = namesOfAnimal.stream().sorted((x,y)-> x.compareTo(y)).toList();
        System.out.println(sortedNameOfAnimals1);

        //Remove duplicates from a list.
        List<Integer> numbers_inc = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> numbers_inc_unique = numbers_inc.stream().distinct().collect(Collectors.toList());
        System.out.println(numbers_inc_unique);

        //Flatten a list of lists of integers into a single list of integers.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flatenList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatenList);

        //Use peek() to debug intermediate results in a stream pipeline.
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        List<String> result = fruits.stream()
                .filter(f -> f.length() > 5)
                .peek(f -> System.out.println("Filtered fruit: " + f))
                .map(String::toUpperCase)
                .peek(f -> System.out.println("Mapped fruit: " + f))
                .toList();
        System.out.println(result);

       //Sort a list of strings by their length.
        List<String> names1 = Arrays.asList("Tom", "Jonathan", "Alex", "Chris");
        List<String> listWithSortedString = names1.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
//        List<String> listWithSortedString = names1.stream().sorted(Comparator.comparingInt(s->s.length())).collect(Collectors.toList());
        System.out.println(listWithSortedString);

        //Sort a list of integers in descending order.
        List<Integer> numbers1 = Arrays.asList(5, 3, 8, 1);
        List<Integer> numbers_list1 =  numbers1.stream().sorted().peek(s-> System.out.println("Sorting value "+s)).collect(Collectors.toList());
        List<Integer> numbers_list2 =  numbers1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(numbers_list2);

        //Find the sum of all even numbers in a list.
        List<Integer> numbers2 = Arrays.asList(2, 3, 4, 5, 6);
        int sum = numbers2.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Convert a list of strings to a set to remove duplicates.
        List<String> items2 = Arrays.asList("apple", "banana", "apple", "orange");
        //method 1
//        Set<String> collect = items2.stream().collect(Collectors.toSet());
//        System.out.println(collect);
        //method 2
//        List<String> stringList = items2.stream().distinct().collect(Collectors.toList());
//        System.out.println(stringList);

//        Use reduce() to find the product of all numbers.
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4);
        //method 1
//        int sum1 = numbers3.stream().mapToInt(x -> x * x).sum();
//        System.out.println(sum1);

        //Find the minimum element from a list using min() and a custom comparator.
        List<String> words1 = Arrays.asList("apple", "banana", "pear", "kiwi");
        Optional<String> min = words1.stream().min(Comparator.comparingInt(String::length));
        System.out.println(min);

        //Use partitioningBy() collector to split numbers into even and odd.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect = numbers4.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect);
//        Group a list of strings by their first character.
        List<String> names4 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Amanda");
        Map<Character, List<String>> collect1 = names4.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(collect1);

    try{
        throw new NullPointerException("null pointer");
    } catch (Exception e){
        System.out.println("null pointer exeception occured");
    }
    finally {
        System.out.println("finally executed");
    }

    }
}
