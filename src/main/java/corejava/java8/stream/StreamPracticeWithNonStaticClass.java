package corejava.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPracticeWithNonStaticClass {
    class Employye{
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

        public Employye(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        StreamPracticeWithNonStaticClass sp = new StreamPracticeWithNonStaticClass();
        List<Employye> listEmp = Arrays.asList(
          sp.new Employye(1, "Alice"),
          sp.new Employye(2, "Bob")
        );

    }
}
