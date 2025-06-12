package sorting.comparable;

public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private int countryCode;

    public Student(int id, String name, int countryCode){
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
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

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}
