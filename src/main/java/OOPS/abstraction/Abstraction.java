package OOPS.abstraction;

public class Abstraction implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bow Bow");
    }


    public static void main(String[] args) {
        Animal ab = new Abstraction();
        ab.makeSound();
    }
}
