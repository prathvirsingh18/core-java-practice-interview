package corejava.java8.annonumousinnerclass;

public class ImplemtingAnimal implements Animal{
    @Override
    public void sound() {
        System.out.println("Animal sounds very lazy");
    }

    public void cat(){
        System.out.println("cat sounds meow");
    }
}
class Test{
    public static void main(String[] args) {
        ImplemtingAnimal im = new ImplemtingAnimal();
        im.sound();
        im.cat();
    }
}

class Test1{
    public static void main(String[] args) {
        // anonymous class is used when we need a one time use implementation
    //In anonymous inner class is a class that is defined without a name and is declared and instantiated in a single statement. It is used when you need to create a one-time-use class, usually for implementing interfaces or extending existing classes.

        //using Animal interface with anonymous class
        //useful bcoz we not need to create a new class that implement interface and then overrride its method
        Animal an = new Animal() {
            //this is anonymous inner class bcoz it dont have any name
            @Override
            public void sound() {
                System.out.println("Bwwww bwwwww");
            }
        };
        an.sound();


        //<----- using anonymous function-->
        //Advantage no need to create a class that will implemt interface and then overide its function in class to provide it definition
        Animal animal = ()-> {
            System.out.println("animal are crazy");
            System.out.println("animal sound crazy");
        };
        animal.sound();
    }


}