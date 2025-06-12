What is an Anonymous Inner Class in Java?
An anonymous inner class is a class that is defined without a name and is declared and instantiated in a single statement. It is used when you need to create a one-time-use class, usually for implementing interfaces or extending existing classes.

1️⃣ Basic Syntax
The general structure of an anonymous inner class looks like this:


new SuperClassOrInterface() {
// Implementation of methods (if interface) or override methods (if extending)
};

SuperClassOrInterface can be:
An interface, where we provide implementations for its methods.
An abstract or concrete class, where we override methods.

2️⃣ Example: Anonymous Inner Class Implementing an Interface
Without Anonymous Inner Class (Using a Named Class)

interface Greeting {
void sayHello();
}

class EnglishGreeting implements Greeting {
@Override
public void sayHello() {
System.out.println("Hello!");
}
}

public class Main {
public static void main(String[] args) {
Greeting g = new EnglishGreeting();
g.sayHello();
}
}
Here, we created a named class EnglishGreeting that implements Greeting.

With Anonymous Inner Class

interface Greeting {
void sayHello();
}

public class Main {
public static void main(String[] args) {
Greeting g = new Greeting() { // Anonymous inner class
@Override
public void sayHello() {
System.out.println("Hello!");
}
};
g.sayHello();
}
}
Instead of creating a separate class (EnglishGreeting), we directly create an instance of an anonymous class that implements Greeting.
This is useful when we need a one-time-use implementation.