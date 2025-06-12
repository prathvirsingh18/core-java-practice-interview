package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q1 {
//Let's say you have a list of Employee objects.
// Each employee has an age field. Can you write a stream-based code snippet to get all employees older than 30?
    private record Employee(String name, String city, int age){};

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "New York", 20));        // 20 to 60
        employees.add(new Employee("Bob", "Los Angeles", 55));
        employees.add(new Employee("Charlie", "Chicago", 15));
        employees.add(new Employee("Diana", "Houston", 24));
        employees.add(new Employee("Ethan", "Phoenix", 45));
        employees.add(new Employee("Fiona", "Philadelphia", 52));
        employees.add(new Employee("George", "San Diego", 30));
        employees.add(new Employee("Hannah", "Dallas", 56));
        employees.add(new Employee("Ian", "San Jose", 36));
        employees.add(new Employee("Jill", "Austin", 29));
        //get all employees older than 30?
        Predicate<Employee> predicate = emp-> emp.age>30;
//        List<Employee> listOFEmpGreaterThan30 = employees.stream().filter(x -> x.age > 30).collect(Collectors.toList());
//        List<Employee> listOFEmpGreaterThan30 = employees.stream().filter(predicate).collect(Collectors.toList());

        List<String> listOFEmpGreaterThan30 = employees.stream().filter(predicate).map(x-> x.name).collect(Collectors.toList());
        System.out.println(listOFEmpGreaterThan30);


    }

}
