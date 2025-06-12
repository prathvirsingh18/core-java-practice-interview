Method referencing in Java is a feature that allows you to refer to methods using :: (double colon) instead of writing a lambda expression. It improves readability and makes the code cleaner.

Why Use Method References?
Shorter and more readable compared to lambda expressions.
Avoids unnecessary lambda boilerplate when calling an existing method.

🔹 Types of Method References in Java
There are four types of method references:

Type	Syntax	Example
1. Reference to a Static Method	ClassName::staticMethod	Math::abs
2. Reference to an Instance Method of a Particular Object	objectName::instanceMethod	"Hello"::toUpperCase
3. Reference to an Instance Method of an Arbitrary Object of a Particular Type	ClassName::instanceMethod	String::length
4. Reference to a Constructor	ClassName::new	ArrayList::new
   🔹 1. Reference to a Static Method
   👉 Instead of using a lambda expression to call a static method, you can directly refer to it.

Example
java
Copy
Edit
import java.util.function.Function;

public class StaticMethodReference {
public static void main(String[] args) {
Function<Integer, Double> lambdaWay = (num) -> Math.sqrt(num); // Using lambda
Function<Integer, Double> methodRefWay = Math::sqrt; // Using method reference

        System.out.println(lambdaWay.apply(25)); // Output: 5.0
        System.out.println(methodRefWay.apply(25)); // Output: 5.0
    }
}
✅ Both are equivalent, but Math::sqrt is cleaner!

🔹 2. Reference to an Instance Method of a Particular Object
👉 You can refer to an instance method of a specific object.

Example
java
Copy
Edit
import java.util.function.Supplier;

public class InstanceMethodReference {
public static void main(String[] args) {
String str = "Hello, Java!";

        Supplier<Integer> lambdaWay = () -> str.length(); // Lambda
        Supplier<Integer> methodRefWay = str::length; // Method Reference
        
        System.out.println(lambdaWay.get()); // Output: 12
        System.out.println(methodRefWay.get()); // Output: 12
    }
}
✅ Instead of () -> str.length(), we use str::length.

🔹 3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
👉 Used when working with streams or collections. It applies to any object of a given type.

Example
java
Copy
Edit
import java.util.Arrays;
import java.util.List;

public class ArbitraryInstanceMethodReference {
public static void main(String[] args) {
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Lambda
        names.forEach(name -> System.out.println(name));

        // Using Method Reference
        names.forEach(System.out::println);
    }
}
✅ Instead of name -> System.out.println(name), we use System.out::println.

🔹 4. Reference to a Constructor
👉 You can refer to a constructor when creating new objects.

Example
java
Copy
Edit
import java.util.function.Supplier;

class MyClass {
MyClass() {
System.out.println("MyClass Constructor Called");
}
}

public class ConstructorReference {
public static void main(String[] args) {
// Using Lambda
Supplier<MyClass> lambdaWay = () -> new MyClass();

        // Using Constructor Reference
        Supplier<MyClass> methodRefWay = MyClass::new;

        lambdaWay.get(); // Output: MyClass Constructor Called
        methodRefWay.get(); // Output: MyClass Constructor Called
    }
}
✅ Instead of () -> new MyClass(), we use MyClass::new.

📌 When to Use Method References?
When a lambda expression only calls a method (i.e., no additional logic).
When you want to make the code more concise and readable.
When working with functional interfaces like Function<T, R>, Supplier<T>, Consumer<T>, etc.
