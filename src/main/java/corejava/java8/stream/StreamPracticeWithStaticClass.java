package corejava.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeWithStaticClass {
    static class Employee{
        int id;
        String name;

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

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
    List<Employee> listOfEmp = Arrays.asList(
           new Employee(1, "Bob"),
           new Employee(2, "Alice")
    );


    }
}
