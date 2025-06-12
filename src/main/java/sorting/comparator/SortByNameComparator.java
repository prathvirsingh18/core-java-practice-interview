package sorting.comparator;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());// for string we use compare to method
    }
}
