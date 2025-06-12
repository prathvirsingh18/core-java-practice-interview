package corejava.java8.deafultmethodininterface;

public interface City {
    //default here is a keyword for declaring default method in interface, it is not deafult of access modifiers
    //like private, public, protected
    //Note: Default method can be overide if we want in implemented class
    default void name(String city){
        System.out.println("City name is "+city);
    }

    void country();
}

class Test implements City{
// Note City is on showing country method to implement
    @Override
    public void country() {
        System.out.println("India");
    }

    //if we want we can override the default method
   //it should be public because by default method in interface is public and we are not
    //allowed to change its access modifier
      public void name(String s){
          System.out.println("name  "+s);
    }

    public static void main(String[] args) {
        City test = new Test();
        test.name("Indore");// accessing default method
        test.country();

    }
}
