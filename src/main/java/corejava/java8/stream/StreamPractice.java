package corejava.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        //create a stream from list
        List<String> list = Arrays.asList("hello", "Hi", "How", "are", "you");
        Stream<String> stream = list.stream();

        //create a parallel stream
        Stream<String> parallelStream =  list.parallelStream();

        //Write a stream pipeline to filter even numbers from a list and collect
        //them into a new list
        List<Integer> listIntegers = Arrays.asList(4,85,82,1,86,3,17,2,8,1,6);
        List<Integer> evenNumberList = listIntegers.stream().filter(x-> x%2 == 0).collect(Collectors.toList());
        System.out.println(evenNumberList);

        //What's the difference between map() and flatMap() in Streams?
        //map() transforms each element
        //flatMap() flattens the nested structure
        Stream.of("a", "bh", "kikj").map(String::length);//output: 1,2,4

         List<List<String>> listList = Arrays.asList(Arrays.asList("a","v"), Arrays.asList("sfs", "dfs"));
         List<String> ans = listList.stream().flatMap(List::stream).collect(Collectors.toList());//flat map turn nested list to single list
        System.out.println(ans);
        // use map for 1:1 transformation use flatmap for 1:N transformation

        //forEach vs map
        //forEach is a terminal : executes and actionand doesnot return any stream
        //map is intermediate it transforms elements and return value

        // list of square of a number
        List<Integer> lsitOfInteger = Arrays.asList(1,5,3,8,15,2,3);
        List<Integer> squareOfANumber = lsitOfInteger.stream().map(x->x*x).collect(Collectors.toList());
        squareOfANumber.forEach(System.out::println);

        //Collectors.toMap()
        //it will give key error if we have same length of string for more than one string so we need to use merge function
        //or we should have string with different length
        List<String> listOfString = Arrays.asList("apple", "banana", "pears");
//        Map<Integer, String> mapOfStringLength = listOfString.stream().collect(Collectors.toMap(String::length, s->s));
//        mapOfStringLength.forEach((k, v)-> System.out.println("Key: "+k+ "value :"+v));

        //to handle key error
        List<String> listOfString1 = Arrays.asList("apple", "banana", "pears");
        Map<Integer, String> mapWithMergeFunction = listOfString1.stream().collect(Collectors.toMap(String::length, v->v, (s1, s2)-> s1+" "+s2 ));
        //(s1, s2)-> s1+" "+s2 ) this is merge function it will merge values if length of string is same
        mapWithMergeFunction.forEach((k,v)-> System.out.println("Key "+k +" value "+v));
        //output
        // Key 5 value apple pears
        //Key 6 value banana

        //convert list of objects to map
        class Employee{
            int id;
            String name;

            public Employee(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        List<Employee> employeeList = Arrays.asList(new Employee(12, "ALice"),
                new Employee(2, "Bob"),
                new Employee(3, "charlie")
                );
        Map<Integer, String> mapOfEmployee = employeeList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        mapOfEmployee.forEach((k,v)-> System.out.println("k "+k+" v "+v));
    }
}
