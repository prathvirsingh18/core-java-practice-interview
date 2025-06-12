package corejava.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public record Person(String name, String city){};
    public record PersonX(String name, String city, int age){};
    class Employee{
        String name;
        String city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Employee(String name, String city) {
            this.name = name;
            this.city = city;
        }
    }


    public static void main(String[] args) {
        //convert a list to upper case
        List<String> listOfString = Arrays.asList("hello", "hi", "howareyou");
        List upperCaseList = listOfString.stream().map(x-> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCaseList);

        //find maximum element in a list of integers
        List<Integer> listOfIntegers = Arrays.asList(1,2,14,51,5,22,6,17);
        int ans = listOfIntegers.stream().max(Integer::compare).orElseThrow();
        //other way of writing above
        int ans1 = listOfIntegers.stream().max((a,b)-> Integer.compare(b, a)).orElseThrow();
        System.out.println(ans1);
//        Person person = new Person("ravi", "indore");
//        System.out.println(person.city());

        //Group a list of people by city.
        List<Person> personsList = Arrays.asList(
                new Person("Alice", "Delhi"),
                new Person("Bob", "Mumbai"),
                new Person("Charlie", "Delhi"),
                new Person("Rob", "Delhi"),
                new Person("Charlie", "Merut")
        );

        Map<String, List<Person>> groupingPersonByCity = personsList.stream().collect(Collectors.groupingBy(Person::city));
        groupingPersonByCity.forEach((k, v)-> v.forEach(System.out::println));

        //Count the frequency of each character in a string.
        String string = "HelloHi";
        Map<Character , Long> output = string.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        System.out.println(output);

        //Group by city and sum age
        List<PersonX> personsList1 = List.of(
                new PersonX("Alice", "Delhi", 30),
                new PersonX("Bob", "Delhi", 25),
                new PersonX("Carol", "Mumbai", 35)
        );

        Map<String, Integer> sumOfAgeAccordingToCity = personsList1.stream().collect(Collectors.groupingBy(p-> p.city, Collectors.summingInt(x->x.age)));
        sumOfAgeAccordingToCity.forEach((k,v)-> System.out.println("City is : "+k +" age is: "+v));

        //Group by city and collect names only
        Map<String, List<String>> map = personsList1.stream().collect(Collectors.groupingBy(PersonX::city, Collectors.mapping(PersonX::name, Collectors.toList())));
        System.out.println(map);

        //Filter even numbers and collect to a list.
        List<Integer> lisOfInteger = Arrays.asList(1,5,2,6,4,25,14,2,852);
        List<Integer> ansOfInteger = lisOfInteger.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(ansOfInteger);

        //Get the first non-repeated character in a string.
        String input = "swiss";
     char cd =   input.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c->c , LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get()
                .charValue();

        System.out.println(cd);


        //Think of it like folding a list into one value — like summing numbers, concatenating strings, or finding a maximum.
        List<Integer> li = Arrays.asList(1,2,54,4,5,54,54,5425,425,454,542);
       // Integer sum = li.stream().reduce(0, Integer::sum);
        Integer sum = li.stream().reduce(0, (a,b)-> a+b);
        System.out.println(sum);

        // concatenate string using reduce()
        List<String> stringList = Arrays.asList("heloo", "hi", "how");
//        String reduceString = stringList.stream().reduce("", (a, b) -> a.concat(b));
        String reduceString = stringList.stream().reduce("", String::concat);
        System.out.println(reduceString);

        //find the second largest numbers using streams
        List<Integer> listOfInteger = Arrays.asList(5,4,2,8,1,5,21,1,5,15,54,5);
      int x =  listOfInteger.stream()
                .sorted(Integer::compareTo)
                .distinct()
                .findFirst()
                .orElse(null);
        System.out.println(x);

      //find duplicate element in list
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob");
        Set<String> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(collect);


        //find second largest older person in each city
        List<PersonX> personsList2 = List.of(
                new PersonX("Alice", "Delhi", 30),
                new PersonX("Bob", "Delhi", 25),
                new PersonX("Carol", "Mumbai", 35),
                new PersonX("Caroline", "Mumbai", 31),
                new PersonX("Carol", "Mumbai", 35)
        );

        Map<String, Optional<PersonX>> secondMaxAge = personsList2.stream().collect(Collectors.groupingBy(PersonX::city, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream().sorted(
                        Comparator.comparingInt(PersonX::age).reversed())
                        .skip(1)
                        .findFirst()
                )
        ));
        System.out.println(secondMaxAge);


        Map<String, Optional<PersonX>> collect1 = personsList2.stream().collect(Collectors.groupingBy(PersonX::city, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream()
                        .sorted(Comparator.comparingInt(PersonX::age).reversed())
                        .skip(1)
                        .findFirst()


        )));

        collect1.forEach((k,v)-> System.out.println("Key is: "+k +" value is "+v));

    }
}
