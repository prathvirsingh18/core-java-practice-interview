package OOPS.inheritence;

public class Vehicle {
    void startSound(){
        System.out.println("Wroom wroom");
    };
}
class Tesla extends Vehicle{
    void showManual(){
        System.out.println("Showing safety details");
    }

}
class Test{
    public static void main(String[] args) {
        Tesla tesla = new Tesla();
        tesla.startSound();//inherited from parent
        tesla.showManual();
    }
}
