package practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
//  You’re given a list of students. Filter out those who scored less than 60,
//  then sort the remaining students by score in descending order. Can you implement this using streams?
    public record Student(String name, int marks) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 85),
                new Student("Bob", 22),
                new Student("Charlie", 90),
                new Student("Diana", 88),
                new Student("Ethan", 65),
                new Student("Fiona", 78),
                new Student("George", 92),
                new Student("Hannah", 69),
                new Student("Ian", 55),
                new Student("Jill", 80),
                new Student("Kevin", 91),
                new Student("Laura", 27),
                new Student("Mike", 68),
                new Student("Nina", 74),
                new Student("Oscar", 89),
                new Student("Paula", 42),
                new Student("Quinn", 70),
                new Student("Rachel", 95),
                new Student("Steve", 77),
                new Student("Tina", 73)
        );
       List<Student> sortedStudent =  students.stream().filter(st-> st.marks()>60).sorted(Comparator.comparingInt(Student::marks).reversed()).collect(Collectors.toList());
        System.out.println(sortedStudent);
    }
}
