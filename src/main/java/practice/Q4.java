package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {
    //multi level sorting First sort by name (descending, nulls last), then by price (ascending).
    record Product(String name, double price){};

    public static void main(String[] args) {
        List<Product> listOfProducts = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product(null, 749.50),
                new Product("Tablet", 450.00),
                new Product("Headphones", 129.95),
                new Product("Smartwatch", 199.99),
                new Product("Camera", 549.25),
                new Product("Printer", 149.80),
                new Product("Monitor", 299.99),
                new Product("Keyboard", 89.99),
                new Product("Mouse", 45.75),
                new Product("Speaker", 120.00),
                new Product("Router", 179.50),
                new Product("Hard Drive", 99.99),
                new Product("USB Cable", 15.99),
                new Product("Charger", 25.50),
                new Product("Webcam", 85.00),
                new Product("Microphone", 130.25),
                new Product("Projector", 650.00),
                new Product("Drone", 999.00),
                new Product("TV", 1200.00),
                new Product(null, 1200.00)
        );

        List<Product> finalSortedList = listOfProducts.stream()
                .sorted(Comparator.comparing(Product::name, Comparator.nullsLast(String::compareTo)).thenComparing(Product::price)).collect(Collectors.toList());
//        List<Product> sorted = listOfProducts.stream()
//                .sorted(
//                        Comparator
//                                .comparing(Product::name, Comparator.nullsLast(Comparator.reverseOrder()))
//                                .thenComparing(Product::price) // ascending price
//                )
//                .collect(Collectors.toList());

        System.out.println(finalSortedList);
    }
}
