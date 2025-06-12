package corejava.java8.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println("ispResent "+ empty.isPresent());

        Optional<String> data = Optional.of("hello world");
        System.out.println("isPresent "+data.isPresent());

        System.out.println(data.get());//returns value if present, if not present then it will return no such element present exception
       // System.out.println(empty.get());

        if(empty.isPresent()){// check first value is present or not then use it
            //System.out.println(empty.get());
        }

        //filter method
        System.out.println(data.filter(s->s.equals("hello world")));//return Optional[hello world] because it matches
        System.out.println(data.filter(s->s.equals("hello world1")));//return Optional.empty because it do not matches

        //orElse method
        System.out.println(data.orElse("default vakue"));//if data is emnpty orelse value will be printed otherwise data value will be printed

        //ifPresent, function operation if value present otherwise do nothing
       data.ifPresent(System.out::println);
       empty.ifPresent(System.out::println);//prints nothing

    }
}
