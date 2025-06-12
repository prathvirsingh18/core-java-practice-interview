package sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "prathvi", 91));
        studentList.add(new Student(221, "raj", 91));
        studentList.add(new Student(45, "singh", 01));
        studentList.add(new Student(3, "chouhan", 10));

        System.out.println("before Sorting");
        studentList.forEach(System.out::println);

        //Collections.sort(studentList);//no instance(s) of type variable(s) T exist so that Student conforms to Comparable<? super T>
      //after implementing comparable interface above error is gone
        Collections.sort(studentList);
        System.out.println("after sorting");
        studentList.forEach(System.out::println);
    }
}
