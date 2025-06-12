package practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    record Person(String name){};
    public static void main(String[] args) {
        //Can you show how to use a custom comparator within a stream
        // to sort a list of objects, say, by length of their name fields?
        List<Person> peopleList = List.of(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Jonathan"),
                new Person("Eve"),
                new Person("Charlotte"),
                new Person("Dan")
        );

        List<String> lengthOfString =  peopleList.stream().sorted(Comparator.comparing(s->s.name().length())).map(Person::name).collect(Collectors.toList());
        System.out.println(lengthOfString);

        //What happens if two objects have the same length? How would you break the tie?
        // if two objects have same length then one coming first will be first in list
        //and to break a tie we can sort first using there length and then by name
      List<Person> personList =  peopleList.stream().sorted(Comparator.comparingInt((Person p) ->p.name().length()).thenComparing(Person::name)).collect(Collectors.toList());
        System.out.println(personList);
    }
}
