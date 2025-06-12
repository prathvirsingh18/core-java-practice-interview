package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    //Imagine some entries in your list might have null names.
    // How would you sort the list but push all entries with null names to the end?
    private record Product(String name, double price){};

    public static void main(String[] args) {
        List<Product> productsList = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product(null, 749.50),
                new Product("Tablet", 450.00),
                new Product("Headphones", 129.95),
                new Product(null, 199.99)
        );

        // How would you sort the list but push all entries with null names to the end?
//        List<Product> collect = productsList.stream().sorted(Comparator.comparing(emp -> emp.price)).collect(Collectors.toList());
        List<Product> collect = productsList.stream().sorted(Comparator.comparing(Product::name, Comparator.nullsLast(String::compareTo))).collect(Collectors.toList());
        System.out.println(collect);
    }
}
